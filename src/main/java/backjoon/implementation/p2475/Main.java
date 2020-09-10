package backjoon.implementation.p2475;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();

		StringTokenizer st = new StringTokenizer(reader.readLine());
		long sum = 0;
		while(st.hasMoreTokens()) {
			sum += square(Integer.parseInt(st.nextToken()));
		}
		System.out.println(sum % 10);
	}

	private static long square(int n) {
		return n * n;
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

