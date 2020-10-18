package backjoon.string.p11816;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		String x = reader.readLine();

		if(x.startsWith("0x")) {
			System.out.println(convertTo16To10(x));
		}else if(x.startsWith("0")) {
			System.out.println(convert8To10(x));
		}else {
			System.out.println(x);
		}

	}

	private static int convert8To10(String x) {
		x = x.substring(1);
		int n = Integer.parseInt(x);
		int ret = 0;
		int exp = 0;
		while(n != 0) {
			int remainder = n % 10;
			ret += pow(8, exp) * remainder;
			n /= 10;
			exp++;
		}

		return ret;
	}

	private static int pow(int base, int exp) {
		if(exp == 0) return 1;
		int ret = 1;
		while(exp > 0) {
			ret *= base;
			exp--;
		}
		return ret;
	}


	private static int convertTo16To10(String x) {
		x = x.substring(2);
		int ret = 0;
		for (int i = 0; i < x.length(); i++) {
			char c = x.charAt(x.length()-1-i);
			if(isNumber(c)){
				int n = c-48;
				ret += pow(16, i) * n;
			}else {
				int n = c-87;
				ret += pow(16, i) * n;
			}
		}
		return ret;
	}

	private static boolean isNumber(char c) {
		if(c >= 48 && c <= 57) return true;
		return false;
	}

}

class InputReader {
	private BufferedReader br;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public InputReader(String filepath) {
		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}
