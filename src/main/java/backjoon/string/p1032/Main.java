package backjoon.string.p1032;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.io.*;
/*
백준 1032번 - 명령 프롬프트
https://www.acmicpc.net/problem/1032
 */
public class Main {
	static int n;
	static String[] inputs;

	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();

		inputs = new String[n];
		for (int i = 0; i < n; i++) {
			inputs[i] = reader.readLine();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputs[0].length(); i++) {
			boolean isAllMatched = true;
			for (int j = 0; j < inputs.length-1; j++) {
				if(inputs[j].charAt(i) != inputs[j+1].charAt(i)) {
					isAllMatched = false;
					sb.append("?");
					break;
				}
			}
			if(isAllMatched) sb.append(inputs[0].charAt(i));
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

