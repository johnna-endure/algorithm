package backjoon.implementation.p10996;


import java.io.*;

/*
백준 10996번 - 별 찍기 21
https://www.acmicpc.net/problem/10996
 */
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader();
		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();

		print(n);
	}

	private static void print(int n) {
		if(n == 1) {
			System.out.println("*"); return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2*n; i++) {
			for (int j = 0; j < n; j++) {
				if((i+j) % 2 == 0) {
					sb.append("*");
					continue;
				}
				if(j != n-1) sb.append(" ");
			}
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
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

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
}
