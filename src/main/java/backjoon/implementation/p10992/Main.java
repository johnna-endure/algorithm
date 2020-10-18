package backjoon.implementation.p10992;

import java.io.*;

/*
별 찍기 17
https://www.acmicpc.net/problem/10992
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();

		int n = reader.readInt();

		print(n);
	}

	private static void print(int n) {
		int max_l = 2*n-1;
		int mid = max_l/2;
		int head = mid; int tail = mid;

		StringBuilder sb = new StringBuilder();
		while(head >= 0 && tail < max_l) {
			sb.append(createRow(head, tail));
			head--; tail++;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String createRow(int head, int tail) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= tail; i++) {
			if(i == head || i == tail || head == 0) {
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
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}
