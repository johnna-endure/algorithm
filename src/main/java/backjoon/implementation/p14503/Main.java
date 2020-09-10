package backjoon.implementation.p14503;

import java.io.*;
import java.util.StringTokenizer;

/*
백준 14503번 - 로봇 청소기
https://www.acmicpc.net/problem/14503
 */
public class Main {
	static int n,m;
	static int[][] room;
	static boolean[][] cleaned;
	static int[][] directions = {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		cleaned = new boolean[n][m];

		st = new StringTokenizer(reader.readLine());
		int start_r = Integer.parseInt(st.nextToken());
		int start_c = Integer.parseInt(st.nextToken());
		int start_d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = start_r;
		int c = start_c;
		int d = start_d;
		cleaned[r][c] = true;
		int cleanCnt = 1;
		while(true) {
			int nextD = (d+3)%4;
			int nextR = r + directions[nextD][0];
			int nextC = c + directions[nextD][1];

			if(room[nextR][nextC] == 0 && !cleaned[nextR][nextC]) {
				cleanCnt++;
				r = nextR; c = nextC; d=nextD;
				cleaned[r][c] = true;
				continue;
			}

			if(is4waysCleanedOrWall(r,c)) {
				int behindR = r - directions[d][0];
				int behindC = c - directions[d][1];
				if (room[behindR][behindC] == 1) break;
				if(room[behindR][behindC] == 0) {
					r = behindR; c = behindC;
					continue;
				}
			}
			d = nextD;
		}

		System.out.println(cleanCnt);
	}
	/*
	해당 위치의 모든 방향으로 청소가 되어있거나 벽이 있는 경우
	 */
	public static boolean is4waysCleanedOrWall(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nextR = r+directions[i][0];
			int nextC = c+directions[i][1];
			if(room[nextR][nextC] == 0 && !cleaned[nextR][nextC]) return false;
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

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
}
