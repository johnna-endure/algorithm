package backjoon.graph.floyd.p1389;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
케빈 베이컨의 6단계 법칙
https://www.acmicpc.net/problem/1389
 */
public class Main {
	static int n,m, INF=123456789;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(adj[i], INF);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			adj[u][v] = 1;
			adj[v][u] = 1;
		}
		floyd();
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}
		int minUser = -1;
		int kebinSum = INF;
		for (int i = 0; i < n; i++) {
			int rowSum = 0;
			for (int j = 0; j < n; j++) {
				rowSum += adj[i][j];
			}
			if(kebinSum > rowSum) {
				minUser = i+1;
				kebinSum = rowSum;
			}
		}
		System.out.println(minUser);
	}
	public static void floyd(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) adj[i][j] = 0;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
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
