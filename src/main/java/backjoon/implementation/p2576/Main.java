package backjoon.implementation.p2576;

import java.io.*;

/*
백준 2576번 - 홀수
https://www.acmicpc.net/problem/2576
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) {
			int n = reader.readInt();
			if(n % 2 == 1) {
				sum += n;
				min = Math.min(n, min);
			}
		}
		if(sum == 0){
			System.out.println(-1); return;
		}
		System.out.println(sum);
		System.out.println(min);

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
