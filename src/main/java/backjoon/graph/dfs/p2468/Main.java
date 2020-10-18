package backjoon.graph.dfs.p2468;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
안전 영역
acmicpc.net/problem/2468
 */
public class Main {
	static int n;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");

		n = reader.readInt();

		map = new int[n][n];
		int minH = 0;
		int maxH = 100;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}

		int result = 0;

		minH = minH == 0 ? minH : minH-1;
		for (int rainHeight = minH; rainHeight <= maxH; rainHeight++) {
			boolean[][] visited = new boolean[n][n];
			int secureArea = 0;
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if(!visited[row][col] && rainHeight < map[row][col]) {
						searchSecureArea(row,col,rainHeight,visited);
						secureArea++;
					}
				}
			}
			result = Math.max(secureArea, result);
		}
		System.out.println(result);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static void searchSecureArea(int row, int col, int rainHeight, boolean[][] visited) {
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nextRow = row+dr[i];
			int nextCol = col+dc[i];
			if(isRange(nextRow, nextCol) && !visited[nextRow][nextCol]
					&& rainHeight < map[nextRow][nextCol]) {
				searchSecureArea(nextRow, nextCol, rainHeight, visited);
			}
		}
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