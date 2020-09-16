package backjoon.string.p10798;

import java.io.*;

/*
백준 10798번  - 세로 읽기
https://www.acmicpc.net/problem/10798
 */
public class Main {
	static String[] board;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();

		board = new String[5];
		for (int i = 0; i < 5; i++) {
			board[i] = reader.readLine();
		}
		StringBuilder sb = new StringBuilder();
		for (int col = 0; col < 15; col++) {
			for (int row = 0; row < 5; row++) {
				if(col < board[row].length()) {
					sb.append(board[row].charAt(col));
				}
			}
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

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
}
