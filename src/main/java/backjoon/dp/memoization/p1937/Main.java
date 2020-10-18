package backjoon.dp.memoization.p1937;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
욕심쟁이 판다
https://www.acmicpc.net/problem/1937
 */
public class Main {
	static int n;
	static int[][] forest,cache;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		forest = new int[n][n];
		cache = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(cache[i], -1);
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ret = Math.max(ret, dfs(i,j));
			}
		}
		System.out.println(ret);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static int dfs(int r, int c) {
		if(isStuck(r,c)) return 1;
		if(cache[r][c] != -1) return cache[r][c];

		int ret = 1;
		for (int i = 0; i < 4; i++) {
			int nextR = r+dr[i]; int nextC = c+dc[i];
			if(isRange(nextR, nextC)
					&& forest[nextR][nextC] > forest[r][c]) {
				ret = Math.max(dfs(nextR, nextC)+1, ret);
			}
		}
		return cache[r][c] = ret;
	}

	private static boolean isRange(int r, int c) {
		if(r < 0 || r >= n || c < 0 || c >= n) return false;
		return true;
	}

	private static boolean isStuck(int r, int c) {
		int hereAmount = forest[r][c];
		for (int i = 0; i < 4; i++) {
			int nextR = r+dr[i]; int nextC = c+dc[i];
			if(isRange(nextR, nextC) && hereAmount < forest[nextR][nextC]) return false;
		}
		return true;
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
