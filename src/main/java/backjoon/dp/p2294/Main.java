package backjoon.dp.p2294;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
동전 2
https://www.acmicpc.net/problem/2294
 */
public class Main {
	static int n,k,INF = 987654321;
	static int[] coins;
	static int[] dp;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		coins = new int[n];
		dp = new int[k+1];
		Arrays.fill(dp, INF);
		for (int i = 0; i < n; i++) { coins[i] = reader.readInt(); }
		
		int ret = solve();
		if(ret > 10000) {
			System.out.println(-1); return;
		}
		System.out.println(ret);
	}

	private static int solve() {
		for (int i = 0; i < coins.length; i++) {
			if(coins[i] < k) dp[coins[i]] = 1;
		}

		for (int i = 0; i <= k; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(i >= coins[j]) {
					dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
				}
			}
		}
		return dp[k];
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