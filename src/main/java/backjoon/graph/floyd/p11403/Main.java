package backjoon.graph.floyd.p11403;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
경로 찾기
 */
public class Main {
	static int n;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		adj = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				int element = Integer.parseInt(st.nextToken());
				adj[i][j] = element;
			}
		}

		StringBuilder sb = new StringBuilder();
		floyd();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(adj[i][j]);
				if(j != n-1) sb.append(" ");
				if(j == n-1) sb.append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());

	}

	public static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					boolean noVisitK = adj[i][j] == 1;
					boolean visitK = (adj[i][k] == 1) && (adj[k][j] == 1);
					adj[i][j] = (noVisitK || visitK) ? 1 : 0;
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