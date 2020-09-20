package backjoon.implementation.p10988;

import java.io.*;

/*
백준 10988번 - 팰린드롬인지 확인하기

 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		String input = reader.readLine();

		int head = 0; int tail = input.length()-1;
		while(head <= tail) {
			if(input.charAt(head) != input.charAt(tail)) {
				System.out.println(0); return;
			}
			head++; tail--;
		}
		System.out.println(1);
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
