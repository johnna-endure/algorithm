package backjoon.graph.diijkstra.p4485;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[][] cost;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader();
		InputReader reader = new InputReader("testcase.txt");
		int problemNum = 1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			n = reader.readInt();
			if(n == 0) break;

			map = new int[n][n]; cost = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}

			sb.append("Problem "+problemNum+": "+diijkstra()+"\n");
			problemNum++;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static int diijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
		q.add(new Node(0,0,map[0][0]));
		cost[0][0] = map[0][0];

		while(!q.isEmpty()) {
			Node here = q.poll();

			if(here.cost > cost[here.row][here.col]) continue;

			for (int i = 0; i < 4; i++) {
				int nextR = here.row + dr[i];
				int nextC = here.col + dc[i];
				if(!isRange(nextR, nextC)) continue;
				int nextCost = here.cost + map[nextR][nextC];
				if(nextCost < cost[nextR][nextC]) {
					q.add(new Node(nextR, nextC, nextCost));
					cost[nextR][nextC] = nextCost;
				}
			}
		}
		return cost[n-1][n-1];
	}
	public static boolean isRange(int row, int col) {
		if(row < 0 || row >= n || col < 0 || col >= n) return false;
		return true;
	}
}
class Node {
	int row, col, cost;
	public Node(int row, int col, int cost) {
		this.row = row;
		this.col = col;
		this.cost = cost;
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