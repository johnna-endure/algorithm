package backjoon.tree.p1967;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
트리의 지름
https://www.acmicpc.net/problem/1967
 */
public class Main {
	static int n, maxDiameter = 0;
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			nodes[u].children.add(new Edge(v,w));
		}
		getTreeDiameter(0);
		System.out.println(maxDiameter);
	}
	private static int getTreeDiameter(int index) {

		int maxHeight = 0;
		List<Integer> radius = new ArrayList<>();
		for (int i = 0; i < nodes[index].children.size(); i++) {
			Edge e = nodes[index].children.get(i);
			int height = getTreeDiameter(e.v) + e.w;
			radius.add(height);
			maxHeight = Math.max(height, maxHeight);
		}
		//지름 계산해서 저장
		radius.sort(Comparator.reverseOrder());
		if(radius.size() >= 2) maxDiameter = Math.max(radius.get(0) + radius.get(1), maxDiameter);
		if(radius.size() == 1) maxDiameter = Math.max(radius.get(0), maxDiameter);

		return maxHeight;
	}
}
class Node {
	int id;
	List<Edge> children = new ArrayList<>();
	public Node(int id) {
		this.id = id;
	}
}
class Edge {
	int v,w;
	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
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