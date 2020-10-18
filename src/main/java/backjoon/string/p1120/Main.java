package backjoon.string.p1120;

import java.io.*;
import java.util.StringTokenizer;

/*
백준 1120번 - 문자열
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		String a = st.nextToken(); String b = st.nextToken();

		System.out.println(solve(a,b));
	}

	private static int solve(String a, String b) {
		int min = 123456789;
		for (int bi = 0; bi <= b.length() - a.length(); bi++) {
			int diff = 0;
			for (int ai = 0; ai < a.length(); ai++) {
				if(b.charAt(bi+ai) != a.charAt(ai)) {
					diff++;
				}
			}
			min = Math.min(min, diff);
		}
		return min;
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