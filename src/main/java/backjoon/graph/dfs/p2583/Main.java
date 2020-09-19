package backjoon.graph.dfs.p2583;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static int[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[m][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			fillRectangle(x1, y1, x2, y2);
		}

		visited = new boolean[m][n];
		int count = 0;
		List<Integer> areas = new ArrayList<>();
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if(board[row][col] == 0 && !visited[row][col]){
					areas.add(dfs(row, col));
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(areas.stream()
				.sorted()
				.map(n -> String.valueOf(n))
				.reduce((s1, s2) -> s1 + " " + s2).get());
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static int dfs(int row, int col) {
		visited[row][col] = true;

		int area = 1;
		for (int i = 0; i < 4; i++) {
			int nextR = row + dr[i];
			int nextC = col + dc[i];
			if(isRange(nextR, nextC) && board[nextR][nextC] == 0
					&& !visited[nextR][nextC]) area = dfs(nextR, nextC) + area;
		}

		return area;
	}

	private static boolean isRange(int row, int col) {
		if(row < 0 || row >= m || col < 0 || col >= n) return false;
		return true;
	}

	private static void fillRectangle(int x1, int y1, int x2, int y2) {
		for (int row = y1; row < y2; row++) {
			for (int col = x1; col < x2; col++) {
				board[row][col] = 1;
			}
		}
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
