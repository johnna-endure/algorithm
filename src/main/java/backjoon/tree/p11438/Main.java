package backjoon.tree.p11438;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
LCA2
https://www.acmicpc.net/problem/11438
 */
public class Main {
	static int n,k;
	static Node[] nodes;
	static int[][] sparseArr;
	static int[] first, indexToOrder, orderToIndex;
	static List<Integer> eulerPath = new ArrayList<>();
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader();
		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		nodes = new Node[n];
		first = new int[n];
		indexToOrder = new int[n]; orderToIndex = new int[n];
		for (int i = 0; i < n; i++) { nodes[i] = new Node(i); }
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			nodes[u].children.add(v);
			nodes[v].children.add(u);
		}

		boolean[] visited = new boolean[n];
		eulerTravel(0, visited);

		k = log2(eulerPath.size());
		sparseArr = new int[k+1][eulerPath.size()];

		setSparseArray();
//		for (int i = 0; i <= k; i++) {
//			System.out.println(Arrays.toString(sparseArr[i]));
//		}
//		System.out.println();

		int m = reader.readInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int firstU = first[u];
			int firstV = first[v];
			if(firstU > firstV) {
				int temp = firstU;
				firstU = firstV;
				firstV = temp;
			}
			sb.append(query(firstU, firstV) + "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	static int order = 0;
	private static void eulerTravel(int index, boolean[] visited) {
		visited[index] = true;

		Node node = nodes[index];
		indexToOrder[index] = order;
		orderToIndex[order] = index;
		eulerPath.add(index);
		first[index] = eulerPath.size()-1;
		order++;
		for (int i = 0; i < node.children.size(); i++) {
			int childId = node.children.get(i);
			if(!visited[childId]) {
				eulerTravel(childId, visited);
				eulerPath.add(index);
			}
		}
	}

	private static void setSparseArray() {
		for (int i = 0; i < eulerPath.size(); i++) {
			sparseArr[0][i] = indexToOrder[eulerPath.get(i)];
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < eulerPath.size(); j++) {
				if(j+pow(2, i-1) < eulerPath.size()) {
					sparseArr[i][j] = Math.min(sparseArr[i-1][j],
							sparseArr[i-1][j+pow(2, i-1)]);
				}
			}
		}
	}

	private static int query(int start, int end) {
		int length = end-start+1;

		int k = log2(length);
		//2의 제곱수인 경우
//		if(pow(2,k) == length) {
//			return orderToIndex[sparseArr[k][start]]+1;
//		}
		//2의 제곱수가 아닌 경우
		int minOrder = Integer.MAX_VALUE;
		for (int i = 0; i <= k; i++) {
			if((length & (1 << i)) != 0) {
				minOrder = Math.min(sparseArr[i][start], minOrder);
				start += pow(2,i);
			}
		}
		return orderToIndex[minOrder]+1;
	}

	private static int pow(int base, int exp) {
		int ret = 1;
		while(exp != 0) {
			ret *= base;
			exp--;
		}
		return ret;
	}
	/*
	n보다 작거나 같은 2^k의 k를 반환
	 */
	private static int log2(int n) {
		if(n == 0) return 0;
		int cnt = 0;
		while(true) {
			n /= 2;
			cnt++;
			if(n == 0) break;
		}
		return cnt-1;
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