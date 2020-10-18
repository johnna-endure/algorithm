package backjoon.graph.p1987;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static char[][] board;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];

		for (int i = 0; i < r; i++) {
			String row = reader.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = row.charAt(j);
			}
		}

		boolean[] visited = new boolean[26];
		System.out.println(dfs(0,0, visited));
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static int dfs(int r, int c, boolean[] visited) {
		visited[board[r][c]-65] = true;

		int ret = 1;
		for (int i = 0; i < 4; i++) {
			int nextR = r+dr[i]; int nextC = c+dc[i];
			if(isRange(nextR, nextC) && !visited[board[nextR][nextC]-65]) {
				ret = Math.max(dfs(nextR, nextC, visited)+1, ret);
				visited[board[nextR][nextC]-65] = false;
			}
		}

		return ret;
	}

	private static boolean isRange(int row, int col) {
		if(row < 0 || row >= r || col < 0 || col >= c) return false;
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