package backjoon.graph.p9372;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
상근이의 여행
https://www.acmicpc.net/problem/9372
 */
public class Main {
	static int n,m;
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader("testcase.txt");
		int t = reader.readInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			nodes = new Node[n];
			for (int j = 0; j < n; j++) {
				nodes[j] = new Node(j);
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(reader.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				nodes[u].children.add(v);
				nodes[v].children.add(u);
			}
			boolean[] visited = new boolean[n];
			sb.append(getAirplaneCount(0, visited) + "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int getAirplaneCount(int index, boolean[] visited) {
		Node here = nodes[index];
		visited[here.id] = true;

		int ret = 0;
		for (int i = 0; i < here.children.size(); i++) {
			int childIdx = here.children.get(i);
			if(!visited[childIdx]) {
				ret += getAirplaneCount(childIdx, visited)+1;
			}
		}
		return ret;
	}
}
class Node {
	int id;
	List<Integer> children = new ArrayList<>();
	public Node(int id) {
		this.id = id;
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
