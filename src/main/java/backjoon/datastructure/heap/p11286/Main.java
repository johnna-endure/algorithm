package backjoon.datastructure.heap.p11286;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/*
절댓값 힙
https://www.acmicpc.net/problem/11286
 */
public class Main {
	static int n;
	static List<Long> heap = new ArrayList<>();
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			long x = reader.readLong();
			if(x == 0) {
				sb.append(poll()+"\n");
			}else {
				add(x);
			}
		}
		if(sb.length() == 0) return;
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static long poll() {
		if(heap.size() == 0) return 0;
		if(heap.size() == 1) return heap.remove(0);

		long rootVal = heap.get(0);
		long lastVal = heap.remove(heap.size()-1);
		heap.set(0, lastVal);
		int current = 0;

		while(true) {
			int left = current*2+1;
			int right = current*2+2;
			//current가 리프노드일 경우 종료
			if(left >= heap.size()) break;

			long currentAbsVal = abs(heap.get(current));
			long leftAbsVal = abs(heap.get(left));
			int nextCurrent = current;
			if(currentAbsVal >= leftAbsVal) {
				if (currentAbsVal == leftAbsVal) {
					if(heap.get(current) > heap.get(left)) nextCurrent = left;
				}else {
					nextCurrent = left;
				}
			}

			if(right < heap.size() && abs(heap.get(right)) <= currentAbsVal
					&& abs(heap.get(right)) <= leftAbsVal) {
				if(abs(heap.get(right)) == leftAbsVal) {
					if(heap.get(right) < heap.get(left)) nextCurrent = right;
				}else {
					nextCurrent = right;
				}
			}
			if(nextCurrent == current) break;
			swap(nextCurrent, current);
			current = nextCurrent;
		}
//		System.out.println("pop : " + heap);
		return rootVal;
	}

	private static void add(long x) {
		heap.add(x);
		int current = heap.size()-1;
		int parent = (current-1)/2;

		long currentAbsVal = abs(heap.get(current));
		long parentAbsVal = abs(heap.get(parent));

		while(current != 0 && parentAbsVal >= currentAbsVal) {
			if(parentAbsVal == currentAbsVal) {
				if(heap.get(current) > heap.get(parent)) break;
			}
			swap(current, parent);
			current = parent;
			parent = (current-1)/2;
			currentAbsVal = abs(heap.get(current));
			parentAbsVal = abs(heap.get(parent));
		}
//		System.out.println(heap);
	}

	private static void swap(int current, int parent) {
		long temp = heap.get(current);
		heap.set(current, heap.get(parent));
		heap.set(parent, temp);
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
