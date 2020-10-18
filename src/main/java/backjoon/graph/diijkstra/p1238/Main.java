package backjoon.graph.diijkstra.p1238;

import java.io.*;
import java.util.*;

public class Main {
	static int n,m,x;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); //마을의 수
		m = Integer.parseInt(st.nextToken()); //도로의 수
		x = Integer.parseInt(st.nextToken()); //모이는 마을 번호

		int[] timeGoingParty = new int[n+1]; Arrays.fill(timeGoingParty, Integer.MAX_VALUE);
		int[] timeComingHome = new int[n+1]; Arrays.fill(timeComingHome, Integer.MAX_VALUE);

		List<List<Node>> roads = new ArrayList<>();
		List<List<Node>> reverseRoads = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			roads.add(new ArrayList<>());
			reverseRoads.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			roads.get(u).add(new Node(v,t));
			reverseRoads.get(v).add(new Node(u,t));
		}
		diijkstra(x, reverseRoads, timeGoingParty);
		diijkstra(x, roads, timeComingHome);

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(timeComingHome[i] + timeGoingParty[i], max);
		}
		System.out.println(max);

	}

	private static void diijkstra(int start, List<List<Node>> roads, int[] spendTime) {
		Comparator<Node> comparator = Comparator.comparingInt(n -> n.time);
		PriorityQueue<Node> q = new PriorityQueue<>(comparator);
		q.add(new Node(start, 0));
		spendTime[start] = 0;

		while(!q.isEmpty()) {
			Node here = q.poll();
			if(here.time > spendTime[here.id]) continue;

			for (int i = 0; i < roads.get(here.id).size(); i++) {
				Node there = roads.get(here.id).get(i);
				int nextTime = here.time + there.time;

				if(nextTime < spendTime[there.id]) {
					q.add(new Node(there.id, nextTime));
					spendTime[there.id] = nextTime;
				}
			}
		}
	}
}
class Node {
	int id, time;
	public Node(int id, int time) {
		this.id = id;
		this.time = time;
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
