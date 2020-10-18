package backjoon.dp.p1904;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
01타일
https://www.acmicpc.net/problem/1904
 */
public class Main {
	static int MOD = 15746;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		int n = reader.readInt();
		dp = new int[n+1];
		int ret = solve(n);
		System.out.println(ret);
	}

	private static int solve(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		dp[1] = 1; dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%MOD;
		}

		return dp[n];
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

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
	}

	public boolean ready() throws IOException {
		return br.ready();
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
