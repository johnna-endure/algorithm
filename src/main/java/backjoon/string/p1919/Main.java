package backjoon.string.p1919;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		String a = reader.readLine();
		String b = reader.readLine();

		int[] alp_a = new int[26]; int[] alp_b = new int[26];

		countAlphabet(a, alp_a); countAlphabet(b, alp_b);
		int ret = removeCnt(alp_a, alp_b);
		System.out.println(ret);
	}

	private static int removeCnt(int[] alp_a, int[] alp_b) {
		int cnt = 0;
		for (int i = 0; i < alp_a.length; i++) {
			int max = Math.max(alp_a[i], alp_b[i]);
			int min = Math.min(alp_a[i], alp_b[i]);
			cnt += max - min;
		}
		return cnt;
	}

	public static void countAlphabet(String s, int[] arr) {
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)-97] += 1;
		}
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