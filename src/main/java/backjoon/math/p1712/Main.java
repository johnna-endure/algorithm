package backjoon.math.p1712;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int a,b,c;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		StringTokenizer st = new StringTokenizer(reader.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(solve(a,b,c));
	}

	private static int solve(int a,int b,int c) {
		if(b == c || b > c) return -1;

		return Math.floorDiv(a, c-b)+1;
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
