package backjoon.implementation.p2953;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		int participant = -1;
		int max = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int score = 0;
			while(st.hasMoreTokens()) {
				score += Integer.parseInt(st.nextToken());
			}
			if(max < score) {
				participant = i+1;
				max = score;
			}
		}
		System.out.println(participant + " " + max);
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
