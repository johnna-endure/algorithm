package backjoon.tree.traversal.p1991;

import java.io.*;
import java.util.*;

/*
트리 순회
https://www.acmicpc.net/problem/1991
 */
public class Main {
	static int n;
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int index = st.nextToken().charAt(0)-65;
			//left
			String leftStr = st.nextToken();
			if(!leftStr.equals(".")) nodes[index].left = nodes[leftStr.charAt(0)-65];

			//right
			String rightStr = st.nextToken();
			if(!rightStr.equals(".")) nodes[index].right = nodes[rightStr.charAt(0)-65];
		}

		StringBuilder sb = new StringBuilder();
		preOrderPrint(0, sb); sb.append("\n");
		inOrderPrint(0, sb); sb.append("\n");
		postOrderPrint(0,sb);
		System.out.println(sb.toString());
	}

	private static void preOrderPrint(int i, StringBuilder sb) {
		Node here = nodes[i];
		sb.append((char) (i + 65));

		if(here.left != null) {
			int leftIdx = nodes[i].left.index;
			preOrderPrint(leftIdx,sb);
		}

		if(here.right != null) {
			int rightIdx = nodes[i].right.index;
			preOrderPrint(rightIdx,sb);
		}
	}

	private static void inOrderPrint(int i, StringBuilder sb) {
		Node here = nodes[i];

		if(here.left != null) {
			int leftIdx = nodes[i].left.index;
			inOrderPrint(leftIdx,sb);
		}

		sb.append((char) (i + 65));

		if(here.right != null) {
			int rightIdx = nodes[i].right.index;
			inOrderPrint(rightIdx,sb);
		}
	}

	private static void postOrderPrint(int i, StringBuilder sb) {
		Node here = nodes[i];

		if(here.left != null) {
			int leftIdx = nodes[i].left.index;
			postOrderPrint(leftIdx,sb);
		}

		if(here.right != null) {
			int rightIdx = nodes[i].right.index;
			postOrderPrint(rightIdx,sb);
		}

		sb.append((char) (i + 65));

	}
}
class Node {
	int index;
	Node left, right;
	public Node(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return String.format("[left : %d, right : %d]\n", Objects.nonNull(left) ? left.index : -1
				, Objects.nonNull(right) ? right.index : -1);
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