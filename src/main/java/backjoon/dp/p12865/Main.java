package backjoon.dp.p12865;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
평범한 배낭
https://www.acmicpc.net/problem/12865
 */
public class Main {
	static int n,k;
	static Item[] items;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
		items = new Item[n+1];
		dp = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			items[i] = new Item(w,v);
		}

		int ret = solve();
//		for (int i = 0; i <= n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(ret);
	}

	private static int solve() {
		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= 0; j--) {
				dp[i][j] = dp[i-1][j];
				if(j - items[i].w >= 0)
					dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-items[i].w] + items[i].v);
			}
		}
		return dp[n][k];
	}
}
class Item {
	int w,v;
	public Item(int w, int v) {
		this.w = w;
		this.v = v;
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