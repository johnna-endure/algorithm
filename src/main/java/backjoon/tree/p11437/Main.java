package backjoon.tree.p11437;

import java.io.*;
import java.util.*;

/*
LCA
https://www.acmicpc.net/problem/11437
 */
public class Main {
	static int n,m;
	static Node[] modifiedTree, nodes;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		nodes = new Node[n]; //임시 트리
		for (int i = 0; i < n; i++) { nodes[i] = new Node(i);}
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			nodes[u].children.add(v);
			nodes[v].children.add(u);
		}

		modifiedTree = new Node[n];
		restructTree();

		m = reader.readInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			sb.append(findLCA(u,v) + "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int findLCA(int u, int v) {
		int u_depth = modifiedTree[u].depth;
		int v_depth = modifiedTree[v].depth;
		int minDepth = Math.min(u_depth, v_depth);
		//depth 동일하게 맞추기
		u = getAncestor(u, u_depth-minDepth);
		v = getAncestor(v, v_depth-minDepth);

		if(u == v) return u+1;
		else {
			while(u != -1) {
				u = modifiedTree[u].parentId; v = modifiedTree[v].parentId;
				if(u == v) break;
			}
			return u+1;
		}
	}
	//노드의 id에서 go만큼 부모로 이동하고 인덱스를 반환한다.
	private static int getAncestor(int id, int go) {
		for (int i = 0; i < go; i++) {
			id = modifiedTree[id].parentId;
		}
		return id;
	}

	private static void restructTree() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] discovered = new boolean[n];

		for (int i = 0; i < n; i++) {
			modifiedTree[i] = new Node(i);
		}

		q.add(0);
		discovered[0] = true;

		while(!q.isEmpty()) {
			Node here = nodes[q.poll()];

			for (int i = 0; i < here.children.size(); i++) {
				int childId = here.children.get(i);

				if(!discovered[childId]) {
					modifiedTree[here.id].children.add(childId);
					modifiedTree[childId].parentId = here.id;
					modifiedTree[childId].depth = modifiedTree[here.id].depth+1;
					discovered[childId] = true;
					q.add(childId);
				}
			}
		}
	}

	/*
	모든 노드의 depth를 계산해 배열에 저장
	최소 깊이는 0로 지정.
	 */
}
class Node {
	int id, depth, parentId;
	List<Integer> children = new ArrayList<>();
	public Node(int id) {
		this(id, -1, 0);
	}
	public Node(int id, int parentId, int depth) {
		this.id = id;
		this.parentId = parentId;
		this.depth = depth;
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
