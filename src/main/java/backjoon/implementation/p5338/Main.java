package backjoon.implementation.p5338;

import java.io.*;

/*
백준 5338번 - 마이크로소프트 로고
https://www.acmicpc.net/problem/5338
 */
public class Main {
	public static void main(String[] args) {

		System.out.println("       _.-;;-._");
		System.out.println("'-..-'|   ||   |");
		System.out.println("'-..-'|_.-;;-._|");
		System.out.println("'-..-'|   ||   |");
		System.out.println("'-..-'|_.-''-._|");
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
