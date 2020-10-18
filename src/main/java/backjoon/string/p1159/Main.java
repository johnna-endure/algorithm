package backjoon.string.p1159;

import java.io.*;
import java.util.StringTokenizer;

/*
농구 경기
https://www.acmicpc.net/problem/1159
 */
public class Main {
	static int n;
	static int[] firstCharCount;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		firstCharCount = new int[26];
		for (int i = 0; i < n; i++) {
			String name = reader.readLine();
			firstCharCount[name.charAt(0)-97] += 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < firstCharCount.length; i++) {
			if(firstCharCount[i] >= 5) sb.append((char)(i+97));
		}
		if(sb.length() == 0) {
			System.out.println("PREDAJA");
			return;
		}
		System.out.println(sb.toString());
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
