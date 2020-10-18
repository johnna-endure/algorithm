package backjoon.graph.bfs.p7562;

import java.io.*;
import java.util.*;

/*
나이트의 이동
https://www.acmicpc.net/problem/7562
 */
public class Main {
	static int t,n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		t = reader.readInt();

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			n = reader.readInt();
			StringTokenizer st = new StringTokenizer(reader.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(reader.readLine());
			Point dest = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			sb.append(bfs(start, dest)+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	static int[] dc = {1,2,2,1,-1,-2,-2,-1};
	static int[] dr = {2,1,-1,-2,-2,-1,1,2};

	private static int bfs(Point start, Point dest) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] discovered = new boolean[n][n];
		int[][] dist = new int[n][n];

		q.add(start);
		discovered[start.row][start.col] = true;
		dist[start.row][start.col] = 0;

		while(!q.isEmpty()) {
			Point here = q.poll();
			if(here.equals(dest)) break;

			for (int i = 0; i < 8; i++) {
				int nextRow = here.row + dr[i];
				int nextCol = here.col + dc[i];
				if(isRange(nextRow, nextCol) && !discovered[nextRow][nextCol]) {
					discovered[nextRow][nextCol] = true;
					q.add(new Point(nextRow, nextCol));
					dist[nextRow][nextCol] = dist[here.row][here.col] + 1;
				}
			}
		}

		return dist[dest.row][dest.col];
	}

	private static boolean isRange(int row, int col) {
		if(row < 0 || row >= n || col < 0 || col >= n) return false;
		return true;
	}
}
class Point {
	int row, col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Point point = (Point) o;

		if (row != point.row) return false;
		return col == point.col;
	}

	@Override
	public int hashCode() {
		int result = row;
		result = 31 * result + col;
		return result;
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
