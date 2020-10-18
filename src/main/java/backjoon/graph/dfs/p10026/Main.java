package backjoon.graph.dfs.p10026;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
적록색약
https://www.acmicpc.net/problem/10026
 */
public class Main {
	static int n;
	static char[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		board = new char[n][n];

		for (int i = 0; i < n; i++) {
			board[i] = reader.readLine().toCharArray();
		}
		//적록색맹이 아닌 경우
		visited = new boolean[n][n];
		int notRedGreenBlindness = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i,j, board[i][j],false);
					notRedGreenBlindness++;
				}
			}
		}

		//적록색맹인 경우
		visited = new boolean[n][n];
		int redGreenBlindness = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i,j, board[i][j], true);
					redGreenBlindness++;
				}
			}
		}

		System.out.println(notRedGreenBlindness + " " + redGreenBlindness);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static void dfs(int row, int col, char color, boolean isRedGreenBlindness) {

		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dr[i];
			int nextCol = col + dc[i];

			if(isRange(nextRow, nextCol)
					&& !visited[nextRow][nextCol]
					&& isSameColor(color, board[nextRow][nextCol], isRedGreenBlindness)) {
				dfs(nextRow, nextCol, color, isRedGreenBlindness);
			}
		}
	}
	private static boolean isSameColor(char colorA, char colorB, boolean isBlindness) {
		if(isBlindness) {
			if(colorA == 'G' && colorB == 'R') return true;
			if(colorA == 'R' && colorB == 'G') return true;
		}
		if(colorA == colorB) return true;
		return false;
	}

	private static boolean isRange(int row, int col) {
		if(row < 0 || row >= n || col < 0 || col >= n) return false;
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
