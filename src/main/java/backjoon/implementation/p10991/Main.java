package backjoon.implementation.p10991;

import java.io.*;

/*
백준 10991번 - 별 찍기 16
https://www.acmicpc.net/problem/10991
*/
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		int max_l = 2*n-1;

		StringBuilder sb = new StringBuilder();
		int head = (max_l-1)/2; int tail = (max_l-1)/2;
		while(head >= 0) {
			sb.append(createRow(head, tail));
			head--; tail++;
		}

		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String createRow(int head, int tail) {
		StringBuilder sb = new StringBuilder();
		boolean star = true;
		for (int i = 0; i <= tail; i++) {
			if(i >= head) {
				if(star) {
					sb.append("*");
					star = !star;
					continue;
				}
				sb.append(" ");
				star = !star;
				continue;
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
