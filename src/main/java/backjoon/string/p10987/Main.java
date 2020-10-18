package backjoon.string.p10987;

import java.io.*;

/*
모음의 개수
https://www.acmicpc.net/problem/10987
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		String input = reader.readLine();
		int sum = input.chars().filter(c -> {
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u') return true;
			return false;
		}).map(n -> 1).sum();

		System.out.println(sum);
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