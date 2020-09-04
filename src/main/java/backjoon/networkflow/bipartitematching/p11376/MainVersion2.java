package backjoon.networkflow.bipartitematching.p11376;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
자바쟁이 - https://javachoi.tistory.com/

백준 11376번 - 열혈강호2
https://www.acmicpc.net/problem/11376

포드-풀커슨 version
 */
public class MainVersion2 {
	static int N,M,V, INF=987654321;
	static int[][] capacity, flow; // [직원][작업]
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		V = N+M+2;
		capacity = new int[V][V];
		flow = new int[V][V];
		for (int employee = 0; employee < N; employee++) {
			st = new StringTokenizer(br.readLine());
			int taskSize = Integer.parseInt(st.nextToken());
			for (int i = 0; i < taskSize; i++) {
				int task = Integer.parseInt(st.nextToken())-1;
				capacity[employee+2][N+task+2] = 1;
			}
		}

		networkModeling(capacity);
//		Arrays.stream(capacity).forEach(arr -> System.out.println(Arrays.toString(arr)));

		int ret = getMaxFlow(0,1);
		System.out.println(ret);
	}

	private static int getMaxFlow(int source, int sink) {
		int totalFlow = 0;

		while(true) {
			//증가 경로 찾기
			int[] parent = new int[V]; Arrays.fill(parent, -1);
			parent[source] = source;
			Queue<Integer> q = new ArrayDeque<>();
			q.add(source);
			while(!q.isEmpty() && parent[sink] == -1) {
				int here = q.poll();
				for (int there = 0; there < V; there++) {
					if(capacity[here][there] - flow[here][there] > 0 && parent[there] == -1) {
						q.add(there);
						parent[there] = here;
					}
				}
			}
			//증가 경로가 없으면 종료한다
			if(parent[sink] == -1) break;
			//증가 경로를 통해 유량을 얼마나 보낼지 결정한다.
			int amount = INF;
			for (int p = sink; p != source ; p = parent[p]) {
				amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);
			}

			//증가 경로를 통해 유량을 보낸다.
			for (int p = sink; p != source; p = parent[p]) {
				flow[parent[p]][p] += amount;
				flow[p][parent[p]] -= amount;
			}

			totalFlow += amount;
		}
		return totalFlow;
	}

	private static void networkModeling(int[][] capacity) {
		//source -> 직원 간선 추가(용량=2)
		for (int i = 0; i < N; i++) {
			capacity[0][i+2] = 2;
		}

		//작업 -> source 간선 추가(용량=1)
		for (int i = 0; i < M; i++) {
			capacity[N+i+2][1] = 1;
		}
	}
}
