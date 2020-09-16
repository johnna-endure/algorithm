package backjoon.datastructure.heap.p11279;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
백준 11279번 - 최대 힙
https://www.acmicpc.net/problem/11279
 */
public class Main {
	static int n;
	static List<Long> heap = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			long query = reader.readLong();
			if(query != 0) {
				add(query);
			}else {
				sb.append(pop() + "\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void add(long n) {
		heap.add(n);
		int node = heap.size()-1;
		int parent = (node-1)/2;
		while(true) {
			//종결 조건
			if(node == 0) break;
			if(heap.get(node) < heap.get(parent)) break;
			swap(parent, node);
			node = parent;
			parent = (node-1)/2;
		}
	}

	private static long pop() {
		if(heap.size() == 0) return 0;
		if(heap.size() == 1) return heap.remove(0);

		long last = heap.remove(heap.size()-1);
		long max = heap.get(0);
		heap.set(0, last);
		int node = 0;
		while(true) {
			int left = 2*node+1; int right = 2*node+2;
			//종결 조건
			if(left >= heap.size()) break; //자식 노드가 없는 경우(리프노드)

			int next = node;
			if(heap.get(left) > heap.get(node)) next = left;
			if(right < heap.size() && heap.get(right) > heap.get(node)
					&& heap.get(right) > heap.get(left)) next = right;

			if(next == node) break;

			swap(node, next);
			node = next;
		}
		return max;
	}

	private static void swap(int a, int b) {
		long temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
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

