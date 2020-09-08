package backjoon.graph.bfs.p1697;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 1697번 - 숨바꼭질
https://www.acmicpc.net/problem/1697
 */
public class Main {
	static int n,k;
	static boolean[] discovered = new boolean[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bfs(n,k);
	}

	private static void bfs(int start, int destination) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(start, 0));
		discovered[start] = true;

		while(true) {
			Node here = q.poll();

			if(here.n == destination) {
				System.out.println(here.distance);
				break;
			}

			int walkLeft = here.n-1;
			int walkRight = here.n+1;
			int jump = here.n*2;
			int[] arr = {walkLeft, walkRight, jump};
			Arrays.stream(arr)
					.filter(n -> isRange(n))
					.filter(n -> !discovered[n])
					.forEach(n -> {
						q.add(new Node(n, here.distance+1));
						discovered[n] = true;
					});
		}
	}

	private static boolean isRange(int n) {
		if(n >= 0 && n <= 100000) return true;
		return false;
	}

}
class Node {
	int n, distance;

	public Node(int n, int distance) {
		this.n = n;
		this.distance = distance;
	}
}
