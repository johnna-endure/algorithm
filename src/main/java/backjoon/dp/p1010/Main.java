package backjoon.dp.p1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T,N,M;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	T = Integer.parseInt(br.readLine());

	dp = new long[30][30];
	for (int i = 1; i < 30; i++) {
	    dp[1][i] = i;
	}
	solve(29, 29);
	for (int testcase = 0; testcase < T; testcase++) {
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]); M = Integer.parseInt(input[1]);

	    System.out.println(dp[N][M]);
	}
    }

    private static long solve(int n, int m) {
	if(dp[n][m] != 0) return dp[n][m];

	for (int i = 2; i <= n; i++) {
	    for (int j = i; j <= m; j++) {
		for (int k = 1; k < j; k++) {
		    dp[i][j] += dp[i-1][k];
		}
	    }
	}

	return dp[n][m];
    }
}
