package backjoon.implementation.p14500;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;
	static boolean[][] visited;

	static int[] dRow = {-1,1,0,0}; //상 하 좌
	static int[] dCol = {0,0,-1,1};

	static int[][] t_dr = {{-1,0,0},{-1,0,1},{1,0,0},{-1,1,0}}; //  ㅗ,ㅏ,ㅜ,ㅓ
	static int[][] t_dc = {{0,-1,1},{0,1,0},{0,-1,1},{0,0,-1}};

	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				max = Math.max(max, dfs(row, col,1, board[row][col]));
			}
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				max = Math.max(max, getTMinoSum(row, col));
			}
		}
		System.out.println(max);
	}

	public static int getTMinoSum(int row, int col) {
		int max = 0;
		for (int type = 0; type < 4; type++) {
			if(tValidPosition(type, row, col)) {
				int sum = board[row][col];
				for (int i = 0; i < 3; i++) {
					int nextR = row + t_dr[type][i];
					int nextC = col + t_dc[type][i];

					sum += board[nextR][nextC];
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	private static boolean tValidPosition(int type, int row, int col) {
		for (int i = 0; i < 3; i++) {
			int nextR = row + t_dr[type][i];
			int nextC = col + t_dc[type][i];

			if(!isRange(nextR, nextC)) return false;
		}
		return true;
	}

	public static int dfs(int row, int col, int length, int sum) {
		if(!isRange(row, col)) return 0;
		if(length == 4) return sum;

		visited[row][col] = true;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			int nextRow = row+dRow[i]; int nextCol = col+dCol[i];

			if(isRange(nextRow, nextCol) && !visited[nextRow][nextCol])
				max = Math.max(max, dfs(nextRow, nextCol, length+1, sum + board[nextRow][nextCol]));
		}
		visited[row][col] = false;

		return max;
	}

	private static boolean isRange(int row, int col) {
		if(row < 0 || row >= n || col < 0 || col >= m) return false;
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

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
}
