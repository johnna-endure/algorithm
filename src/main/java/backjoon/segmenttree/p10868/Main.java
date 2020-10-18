package backjoon.segmenttree.p10868;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
최솟값
https://www.acmicpc.net/problem/10868
 */
public class Main {
	static int[] nums;
	static long[] segmentTree;
	static int n,m;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = reader.readInt();
		}
		segmentTree = new long[4*n];
		init(0, n-1,0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			sb.append(query(a,b,0,0,n-1) + "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static long init(int left, int right, int node) {
		if(left == right) return segmentTree[node] = nums[left];

		int mid = (left+right)/2;
		long leftMin = init(left, mid, 2*node+1);
		long rightMin = init(mid+1, right, 2*node+2);

		return segmentTree[node] = Math.min(leftMin, rightMin);
	}

	private static long query(int targetLeft, int targetRight,
	                         int node, int segLeft, int segRight) {
		if(targetRight < segLeft ||  segRight < targetLeft) return Long.MAX_VALUE;
		if(targetLeft <= segLeft && segRight <= targetRight) return segmentTree[node];

		int mid = (segLeft + segRight)/2;
		long leftMin = query(targetLeft, targetRight, node*2+1, segLeft, mid);
		long rightMin = query(targetLeft, targetRight, node*2+2, mid+1, segRight);
		return Math.min(leftMin, rightMin);
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
