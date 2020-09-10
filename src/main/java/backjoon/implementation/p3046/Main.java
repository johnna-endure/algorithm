package backjoon.implementation.p3046;


import java.io.*;
import java.util.StringTokenizer;

/*
백준 3046번 -  R2
https://www.acmicpc.net/problem/3046
 */
public class Main {
	static int r1,s;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());

		r1 = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		System.out.println(2*s - r1);
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

