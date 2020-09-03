package backjoon.networkflow.bipartitematching.p2188;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2188번 - 축사 배정
https://www.acmicpc.net/problem/2188
*/
public class Main {
	static int[][] edges; // 간선 [cow][barn]
	static int[] aMatch, bMatch;
	static boolean[] visited;
	static int N,M;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		edges = new int[N][M];
		for (int cowNum = 0; cowNum < N; cowNum++) {
			st = new StringTokenizer(br.readLine());
			int barnSize = Integer.parseInt(st.nextToken());
			for (int i = 0; i < barnSize; i++) {
				int barnNum = Integer.parseInt(st.nextToken())-1;
				edges[cowNum][barnNum] = 1;
			}
		}
		System.out.println(bipartiteMatching());
	}
	// 집합 A의 정점 a에서 B의 매칭되지 않은 정점으로 가는 경로를 찾는다
	public static boolean dfs(int a) {
		if(visited[a]) return false; // 재방문 크트. 매칭 수정시 이 한 줄의 코드가 어떻게 작용하는지 유의할 것.
		visited[a] = true;
		for(int b = 0; b < M; ++b) {
			if(edges[a][b] == 1) {
				//b가 아직 매칭되지 않았다면
				if(bMatch[b] == -1) {
					aMatch[a] = b;
					bMatch[b] = a;
					return true;
				}
				//b가 이미 매칭되어있다면 bMatch[b]에서부터 시작해 경로를 찾는다. 찾았을 경우 재귀 호출한 부분에서 경로를 수정한다.
				if(dfs(bMatch[b])) {
					//dfs 호출(재귀호출)에서 경로를 수정했으니 b에 연결된 정점이 없으므로 연결해준다.
					aMatch[a] = b;
					bMatch[b] = a;
					return true;
				}
			}
		}
		return false;
	}

	public static int bipartiteMatching() {
		aMatch = new int[N]; Arrays.fill(aMatch, -1);
		bMatch = new int[M]; Arrays.fill(bMatch, -1);

		int size = 0;
		for (int start = 0; start < N; start++) {
			visited = new boolean[N];

			// 증가 경로, 즉 매칭을 찾은 경우 1의 유량 증가시킨다. 증가 경로를 찾을때 마다 +1 ?  정당성 증명 필요하다.
			if(dfs(start)) ++size;
		}
		return size;
	}
}
