package backjoon.dp.p1309;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
동물원
https://www.acmicpc.net/problem/1309
 */
public class Main {
	static int n, MOD = 9901;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		n = reader.readInt();
		dp = new int[n][3];
		int ret = solve();
		System.out.println(ret);
	}

	private static int solve() {
		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][0] = (dp[i][0] + dp[i-1][j])%MOD;
			}
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%MOD;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%MOD;
		}

		return (dp[n-1][0] + dp[n-1][1] + dp[n-1][2])%MOD;
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
