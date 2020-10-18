package backjoon.graph.diijkstra.p1261;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] board, dist;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(st.nextToken()); //가로 길이
		n = Integer.parseInt(st.nextToken()); //세로 길이
		board = new int[n][m]; dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			String row = reader.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = row.charAt(j)-48;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		System.out.println(diijkstra());
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	private static int diijkstra() {
		Comparator<Node> comparator = (n1,n2) -> {
			if(n1.distance >= n2.distance) return 1;
			else return -1;
		};
		PriorityQueue<Node> q = new PriorityQueue<>(comparator);
		q.add(new Node(0,0,0));
		dist[0][0] = 0;
		while(!q.isEmpty()) {
			Node here = q.poll();

			if(here.distance > dist[here.row][here.col]) continue;

			for (int i = 0; i < 4; i++) {
				int nextR = here.row + dr[i];
				int nextC = here.col + dc[i];
				if(!isRange(nextR, nextC)) continue;

				int weight = board[nextR][nextC] == 0 ? 0 : 1;
				int nextDistance = here.distance + weight;

				if(dist[nextR][nextC] > nextDistance) {
					dist[nextR][nextC] = nextDistance;
					q.add(new Node(nextR, nextC, nextDistance));
				}
			}
		}
		return dist[n-1][m-1];
	}

	private static boolean isRange(int r, int c) {
		if(r < 0 || r >= n || c < 0 || c >= m) return false;
		return true;
	}
}
class Node{
	int row, col, distance;
	public Node(int row, int col, int distance) {
		this.row = row;
		this.col = col;
		this.distance = distance;
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
