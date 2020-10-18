package backjoon.tree.p2533;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
	static int N;
	static int[][] cache;
	static boolean[] visited;
	static List<List<Integer>> adj;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		N = reader.readInt();
		adj = new ArrayList<>();
		cache = new int[N+1][2];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(cache[i], -1);
		}
		for (int i = 0; i <= N; i++) { adj.add(new ArrayList<>());}

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken()); int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		visited = new boolean[N+1];
		int a = solve(1, true);
		int b = solve(1, false);
//		System.out.println(a + " " +b);
		int ret = max(a,b);
		System.out.println(N-ret);
	}

	private static int solve(int node, boolean isEarlyAdaptor) {
		int isEarlyAdaptorVal = isEarlyAdaptor ? 1 : 0;
		if(cache[node][isEarlyAdaptorVal] != -1) return cache[node][isEarlyAdaptorVal];

		visited[node] = true;

		int ret = isEarlyAdaptor ? 0 : 1;
		for (int i = 0; i < adj.get(node).size(); i++) {
			int childNode = adj.get(node).get(i);
			if(visited[childNode]) continue;
			//현재 노드가 ea라면 자식노드는 ea가 아닐 수도 있다.
			if(isEarlyAdaptor) {
				ret += max(solve(childNode, false),
						solve(childNode, true));
				continue;
			}
			//현재 노드가 ea가 아니라면 모든 자식 노드는 ea여야 한다.
			ret += solve(childNode, true);
		}
		visited[node] = false;
//		return ret;
		return cache[node][isEarlyAdaptorVal] = ret;
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

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
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