package backjoon.dp.p10870;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
백준 10870번 - 피보나치 수 5
https://www.acmicpc.net/problem/10870
 */
public class Main {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));

		n = Integer.parseInt(br.readLine());
		dp = new int[21];
		int ret = solve(n);
		System.out.println(ret);
	}

	private static int solve(int n) {
		dp[0] = 0; dp[1] = 1;

		if(n < 2) return dp[n];

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		return dp[n];
	}
}
