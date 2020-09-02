package backjoon.networkflow.p8086;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 6086번 - 최대 유량
https://www.acmicpc.net/problem/6086
 */
public class Main {
	static int N, V = 52, INF = 987654321;
	static int[][] capacity,flow;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		capacity = new int[V][V];
		flow = new int[V][V];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pipeStart = getIndex(st.nextToken().charAt(0));
			int pipeEnd = getIndex(st.nextToken().charAt(0));
			int capacityVal = Integer.parseInt(st.nextToken());

			capacity[pipeStart][pipeEnd] += capacityVal;
			capacity[pipeEnd][pipeStart] += capacityVal; //양방향에서의 포드 풀커슨???
		}

		int ret = networkFlow(0, 25);
		System.out.println(ret);
	}

	public static int networkFlow(int source, int sink) {
		int totalFlow = 0;

		while(true) {
			//증가 경로를 찾는다.
			int[] parent = new int[52]; Arrays.fill(parent, -1);
			Queue<Integer> queue = new ArrayDeque<>();
			parent[source] = source;
			queue.add(source);
			while(!queue.isEmpty() && parent[sink] == -1) {
				int here = queue.poll();
				for (int there = 0; there < V; there++) {
					//잔여 용량이 남아 있는 간선을 따라 탐색한다.
					if(capacity[here][there] - flow[here][there] > 0 && parent[there] == -1) {
//						System.out.format("here : %d, there : %d\n", here, there);
						queue.add(there);
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

	public static int getIndex(char c) {
		//대문자일 경우
		if(c >= 65 && c <= 91) {
			return c-65;
		}
		//소문자인 경우
		if(c >= 97 && c <= 122) {
			return c-71;
		}
		return -1;
	}

}
