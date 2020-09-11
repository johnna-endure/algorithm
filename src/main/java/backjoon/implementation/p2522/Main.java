package backjoon.implementation.p2522;

import java.io.*;

/*
백준 2522번 - 별 찍기 12
https://www.acmicpc.net/problem/2522
 */
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();

		print();
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();

		int head = n-1;
		while(head >= 0) {
			sb.append(createRow(head));
			head--;
		}

		head = 1;
		while(head < n) {
			sb.append(createRow(head));
			head++;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String createRow(int head) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if(i >= head) {
				sb.append("*"); continue;
			}
			sb.append(" ");
		}
		return sb.append("\n").toString();
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
