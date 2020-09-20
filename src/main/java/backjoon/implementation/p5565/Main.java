package backjoon.implementation.p5565;

import java.io.*;

/*
백준 5565번 - 영수증
https://www.acmicpc.net/problem/5565
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		int total = reader.readInt();

		for (int i = 0; i < 9; i++) {
			total -= reader.readInt();
		}
		System.out.println(total);
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
