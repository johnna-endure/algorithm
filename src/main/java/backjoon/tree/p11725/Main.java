package backjoon.tree.p11725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
트리의 부모 찾기
https://www.acmicpc.net/problem/11725
 */
public class Main {
	static int n;
	static Node[] nodes;
	static int[] parent;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		nodes = new Node[n];
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			nodes[u].children.add(v);
			nodes[v].children.add(u);
		}
		boolean[] visited = new boolean[n];
		findParent(0, visited);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			sb.append(parent[i]+1);
			if(i != n-1) sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void findParent(int index, boolean[] visited) {

		Node here = nodes[index];
		visited[index] = true;

		for (int i = 0; i < here.children.size(); i++) {
			int childIdx = here.children.get(i);
			if(!visited[childIdx]) {
				parent[childIdx] = here.id;
				findParent(childIdx, visited);
			}
		}
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