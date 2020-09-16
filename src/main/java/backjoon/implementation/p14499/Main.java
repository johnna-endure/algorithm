package backjoon.implementation.p14499;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 14499번 - 주사위 굴리기
https://www.acmicpc.net/problem/14499
 */
public class Main {
	static int n,m,k;
	static int[][] map;
	static int[] dice = new int[7];
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int start_row = Integer.parseInt(st.nextToken());
		int start_col = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < k; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		simulate(start_row, start_col, q);
	}

	private static void simulate(int start_row, int start_col, Queue<Integer> q) {
		int row = start_row; int col = start_col;
		int bottom = 6; int front = 5; int side = 3;
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int query = q.poll();
			int cur_bottom = bottom; int cur_front = front;
			int cur_side = side;

			//오른쪽으로 굴린다
			if(query == 1) {
				if(!isRange(row, col+1)) continue;
				col++;
				bottom = cur_side;
				side = 7 - cur_bottom;
			}
			//왼쪽으로 굴린다
			if(query == 2) {
				if(!isRange(row, col-1)) continue;
				col--;
				bottom = 7-cur_side;
				side = cur_bottom;
			}
			//위로 굴린다
			if(query == 3) {
				if(!isRange(row-1, col)) continue;
				row--;
				bottom = 7-cur_front;
				front = cur_bottom;
			}
			//아래로 굴린다
			if(query == 4) {
				if(!isRange(row+1, col)) continue;
				row++;
				bottom = cur_front;
				front = 7 - cur_bottom;
			}

			if(map[row][col] == 0) {
				map[row][col] = dice[bottom];
			}else {
				dice[bottom] = map[row][col];
				map[row][col] = 0;
			}
			sb.append(dice[7-bottom]+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
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

