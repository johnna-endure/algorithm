package backjoon.tree.p1068;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
트리
https://www.acmicpc.net/problem/1068
 */
public class Main {
	static int n, removeNode;
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}
		int rootIdx = -1;
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				rootIdx = i;
				continue;
			}
			nodes[parent].children.add(i);
		}
		removeNode = reader.readInt();
		if(removeNode == rootIdx) {
			System.out.println(0); return;
		}
		remove(rootIdx);
		System.out.println(countLeaf(rootIdx));
	}

	private static void remove(int index) {
		Node here = nodes[index];
		for (int i = 0; i < here.children.size(); i++) {
			int child = here.children.get(i);
			if(child == removeNode) {
				here.children.remove(i); return;
			}
			remove(child);
		}
	}

	private static int countLeaf(int index) {
		Node here = nodes[index];

		if(here.children.size() == 0) return 1;

		int cnt = 0;
		for (int i = 0; i < here.children.size(); i++) {
			int child = here.children.get(i);
			cnt += countLeaf(child);
		}
		return cnt;
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
