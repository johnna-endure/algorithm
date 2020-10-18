package backjoon.dp.p1915;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
가장 큰 정사각형
https://www.acmicpc.net/problem/1915
 */
public class Main {
	static int n,m, maxArea = 0;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String line = reader.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = line.charAt(j-1)-48;
			}
		}

		int ret = solve();
		System.out.println(ret);

//		for (int i = 0; i <= n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

	}


	public static int solve() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(!existZero(i,j)) {
					int minArea = getMinArea(i,j);
					int len = (int) Math.sqrt(minArea);
					dp[i][j] = (len+1)*(len+1);
				}else {
					if(arr[i][j] == 1) dp[i][j] = 1;
					else dp[i][j] = 0;
				}
				maxArea = Math.max(dp[i][j], maxArea);
			}
		}
		return maxArea;
	}
	static int[] dr = {-1,-1,0};
	static int[] dc = {-1,0,-1};

	public static int getMinArea(int r, int c) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int nr = r+dr[i]; int nc = c+dc[i];
			min = Math.min(dp[nr][nc], min);
		}
		return min;
	}

	public static boolean existZero(int r, int c) {
		for (int i = 0; i < 3; i++) {
			int nr = r+dr[i]; int nc = c+dc[i];
			if(arr[nr][nc] == 0) return true;
		}
		return false;
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