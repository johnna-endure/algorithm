package backjoon.graph.diijkstra.p1916;

import java.io.*;
import java.util.*;

/*
최소 비용 구하기
https://www.acmicpc.net/problem/1916
 */
public class Main {
	static int n,m;
	static long INF = Long.MAX_VALUE;
	static long[] cost;
	static List<List<Edge>> adj;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();  //도시의 개수
		m = reader.readInt();  //버스의 개수
		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) { adj.add(new ArrayList<>()); }
		cost = new long[n+1];
		Arrays.fill(cost, INF);

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj.get(u).add(new Edge(v,cost));
		}
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(diijkstra(start, end));
	}

	private static long diijkstra(int start, int end) {
		Comparator<Node> comparator = (u,v) -> {
			if(u.cost >= v.cost) return 1;
			else return -1;
		};
		PriorityQueue<Node> q = new PriorityQueue<>(comparator);
		q.add(new Node(start,0));
		cost[start] = 0;

		while(!q.isEmpty()) {
			Node here = q.poll();
			if(cost[here.id] < here.cost) continue;

			for (int i = 0; i < adj.get(here.id).size(); i++) {
				int there = adj.get(here.id).get(i).there;
				int weight = adj.get(here.id).get(i).weight;
				long nextCost = here.cost + weight;
				if(nextCost < cost[there]) {
					q.add(new Node(there, nextCost));
					cost[there] = nextCost;
				}
			}
		}
		return cost[end];
	}
}
class Edge {
	int there, weight;

	public Edge(int there, int weight) {
		this.there = there;
		this.weight = weight;
	}
}
class Node {
	int id;
	long cost;

	public Node(int id, long cost) {
		this.id = id;
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
