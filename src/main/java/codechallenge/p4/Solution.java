package codechallenge.p4;

import java.util.Arrays;

public class Solution {
	static long[][] dp;
	public long solution(String s) {
		int n = s.length();
		dp = new long[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		solve(n/2, n/2, s);
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//
//		}
		return dp[1][s.length()-2];
	}

	public long solve(int start, int end, String s) {
		if(start < 0 || end >= s.length()) return 0;
//		if(start == 0 && end == s.length()-1) return 0;
		long ret = 0;

		if(dp[start][end] != -1) ret += dp[start][end];
		else if(s.charAt(start) != s.charAt(end)) ret += end-start;
		//같은 경우
		if(start > 0) ret += solve(start-1, end, s);
		if(end < s.length()-1)ret += solve(start, end+1,s);

		return dp[start][end] = ret;
	}

}
