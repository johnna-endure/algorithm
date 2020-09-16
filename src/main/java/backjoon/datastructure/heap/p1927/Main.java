package backjoon.datastructure.heap.p1927;

import java.io.*;
import java.util.ArrayList;

/*
백준 1927번 - 최소 힙
https://www.acmicpc.net/problem/1927
 */
public class Main {
	static int n;
	static ArrayList<Long> heap = new ArrayList<>();
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		for (int i = 0; i < n; i++) {
			long query = reader.readLong();
			if(query != 0) {
				add(query);
			}else {
				System.out.println(pop());
			}
		}
	}

	private static void add(long n) {
		heap.add(n);
		int current = heap.size()-1;
		int parent = (current-1)/2;
		while(current != 0 && heap.get(current) < heap.get(parent)) {
			swap(current, parent);
			current = parent;
			parent = (current-1)/2;
		}
	}

	private static void swap(int a, int b) {
		long temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}


	private static long pop() {
		if(heap.size() == 0) return 0;
		if(heap.size() == 1) return heap.remove(0);

		long last = heap.remove(heap.size()-1);
		long min = heap.get(0);
 		heap.set(0, last);

		int here = 0;
		while(true) {
			int left = 2*here+1;
			int right = 2*here+2;
			//현재 노드가 리프 노드일 경우 종료
			if(left >= heap.size()) break;

			int next = here;
			if(heap.get(left) < heap.get(here)) next = left;
			if(right < heap.size() && heap.get(right) < heap.get(here)
					&& heap.get(right) < heap.get(left)) next = right;
			//현재 노드가 자식노드들보다 작아서 바뀌지 않으면 종료
			if(next == here) break;
			swap(next, here);

			here = next;
		}

		return min;
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
