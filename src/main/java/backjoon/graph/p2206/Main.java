package backjoon.graph.p2206;

import java.io.*;
import java.util.*;

/*
벽 부수고 이동하기
https://www.acmicpc.net/problem/2206
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			String rowLine = reader.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = rowLine.charAt(j)-48;
			}
		}
		boolean[][][] discovered = new boolean[n][m][2];
		int ret = solve(board,discovered);
		System.out.println(ret);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static int solve(int[][] board, boolean[][][] discovered) {
		int n = board.length; int m = board[0].length;
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(Point.create(0,0)));
		discovered[0][0][0] = true;

		while(!q.isEmpty()) {
			Node here = q.poll();
			//종결 조건
			if(here.position.equals(Point.create(n-1, m-1))) return here.distance;

			for (int i = 0; i < 4; i++) {
				int nextRow = here.position.row + dr[i]; int nextCol = here.position.col + dc[i];
				if(isRange(nextRow, nextCol, board)) {
					int nextVal = board[nextRow][nextCol];
					if(nextVal == 1) {
						if(here.canBreakWall && !discovered[nextRow][nextCol][1]) {
							Node nextNode = new Node(Point.create(nextRow, nextCol), here.distance+1, false);
							discovered[nextRow][nextCol][1] = true;
							q.add(nextNode);
						}
					}

					if(nextVal == 0) {
						if(here.canBreakWall && !discovered[nextRow][nextCol][0]) {
							Node nextNode = new Node(Point.create(nextRow, nextCol), here.distance+1, true);
							discovered[nextRow][nextCol][0] = true;
							q.add(nextNode);
						}

						if(!here.canBreakWall && !discovered[nextRow][nextCol][1]) {
							Node nextNode = new Node(Point.create(nextRow, nextCol), here.distance+1, false);
							discovered[nextRow][nextCol][1] = true;
							q.add(nextNode);
						}
					}

				}
			}
		}
		return -1;
	}

	private static boolean isRange(int row, int col, int[][] board) {
		int n = board.length; int m = board[0].length;
		if(row < 0 || row >= n || col < 0 || col >= m) return false;
		return true;
	}
}
class Node {
	Point position;
	int distance;
	boolean canBreakWall;
	public Node(Point position){
		this(position, 1, true);
	}

	public Node(Point position, int distance, boolean canBreakWall) {
		this.position = position;
		this.distance = distance;
		this.canBreakWall = canBreakWall;
	}
}
class Point {
	int row, col;
	private Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	static Point create(int row, int col) {
		return new Point(row, col);
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		if(this.row == other.row && this.col == other.col) return true;
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