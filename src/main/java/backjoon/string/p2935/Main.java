package backjoon.string.p2935;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
소음
https://www.acmicpc.net/problem/2935
 */
public class Main {
	static String a, op, b;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		a = reader.readLine();
		op = reader.readLine();
		b = reader.readLine();

		if(op.equals("+")) {
			System.out.println(plus(a,b));
		}

		if(op.equals("*")) {
			System.out.println(multiple(a,b));
		}
	}

	private static String plus(String a, String b) {
		int max_l = Math.max(a.length(), b.length());
		int[] c = new int[max_l];
		c[max_l-a.length()]++;
		c[max_l-b.length()]++;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
		}
		return sb.toString();
	}

	private static String multiple(String a, String b) {
		int l = a.length() + b.length() -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			if(i == 0) {
				sb.append("1"); continue;
			}
			sb.append("0");
		}
		return sb.toString();
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