package backjoon.networkflow.bipartitematching.p11375;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] edge; //간선 : [직원][작업]
	static int[] matched;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		edge = new int[N][M];
		for (int employee = 0; employee < N; employee++) {
			st = new StringTokenizer(br.readLine());
			int taskSize = Integer.parseInt(st.nextToken());
			for (int i = 0; i < taskSize; i++) {
				int task = Integer.parseInt(st.nextToken());
				edge[employee][task-1] = 1;
			}
		}

		int ret = bipartiteMatching();
		System.out.println(ret);

	}

	public static int bipartiteMatching(){
		matched = new int[M]; Arrays.fill(matched, -1);

		int totalMatching = 0;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			if(searchAugmentPath(i)) {
				totalMatching++;
			}
		}

		return totalMatching;
	}

	private static boolean searchAugmentPath(int employee) {
		if(visited[employee]) return false;
		visited[employee] = true;

		for (int task = 0; task < M; task++) {
			if(edge[employee][task] == 1) {

				if(matched[task] == -1 || searchAugmentPath(matched[task])) {
					matched[task] = employee;
					return true;
				}
			}
		}

		return false;
	}
}
