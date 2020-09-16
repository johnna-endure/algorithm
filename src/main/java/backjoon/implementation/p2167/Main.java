package backjoon.implementation.p2167;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] input;
	static long[][] partialSum;
	static int n,m,k;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

		input = new int[n+1][m+1];
		partialSum = new long[n+1][m+1];
		for (int row = 1; row <= n; row++) {
			st = new StringTokenizer(reader.readLine());
			for (int col = 1; col <= m; col++) {
				input[row][col] = Integer.parseInt(st.nextToken());
				partialSum[row][col] = partialSum[row][col-1] + input[row][col];
			}
		}

		k = reader.readInt();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(reader.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			System.out.println(solve(r1,c1,r2,c2));
		}
	}

	private static long solve(int r1, int c1, int r2, int c2) {
		long sum = 0;
		for (int row = r1; row <= r2; row++) {
			sum += partialSum[row][c2] - partialSum[row][c1-1];
		}

		return sum;
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

