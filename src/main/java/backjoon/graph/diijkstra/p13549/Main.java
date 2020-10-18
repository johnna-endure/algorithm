package backjoon.graph.diijkstra.p13549;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
숨바꼭질 3
https://www.acmicpc.net/problem/13549
 */
public class Main {
	static int limit;
	static int[] spendTime;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if(n >= m) {
			System.out.println(n-m);
			return;
		}
		limit = Math.floorDiv(4*m, 3);
		spendTime = new int[limit+1];
		Arrays.fill(spendTime, Integer.MAX_VALUE);

		daiijkstra(n, spendTime);
		System.out.println(spendTime[m]);
	}

	static int[] coefficient = {1,-1,2};
	private static void daiijkstra(int start, int[] spendTime) {
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.time));
		q.add(new Node(start, 0));
		spendTime[start] = 0;

		while(!q.isEmpty()) {
			Node here = q.poll();
			if(here.time > spendTime[here.id]) continue;

			for (int i = 0; i < 3; i++) {
				int there = i != 2 ? here.id + coefficient[i] : here.id * coefficient[i];
				int nextTime = i != 2 ? here.time + 1 : here.time;
				if(isRange(there) && nextTime < spendTime[there]) {
					spendTime[there] = nextTime;
					q.add(new Node(there, nextTime));
				}
			}
		}
	}
	public static boolean isRange(int node) {
		if(node >= 0 && node <= limit) return true;
		return false;
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