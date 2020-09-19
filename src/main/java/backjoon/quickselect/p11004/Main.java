package backjoon.quickselect.p11004;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

/*
백준 11004번 - K번째 수
 */
public class Main {
	static int n,k;
	static Random random = new Random();
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken())-1;
		int[] a = new int[n];

		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(quickSelection(a,k));
//		quickSelection(a, 0 ,n-1);
//		System.out.println(a[k]);
	}

//	private static void quickSelection(int[] a, int start, int end) {
//		if(start == end) return;
//
//		int pivotIdx = getPivotIndex(a,start,end);
//
//		if(pivotIdx < k) quickSelection(a, pivotIdx+1, end);
//		if(pivotIdx > k) quickSelection(a,start,pivotIdx-1);
//		if(pivotIdx == k) return;
//	}

	private static int quickSelection(int[] a, int k) {
		int start = 0; int end = a.length-1;
		while(true) {
			int pivotIdx = getPivotIndex(a, start, end);
			if(pivotIdx < k){
				start = pivotIdx+1; continue;
			}
			if(pivotIdx > k) {
				end = pivotIdx-1; continue;
			}

			if(start == end) return a[start];
			if(pivotIdx == k) {
				return a[pivotIdx];
			}
		}
	}

	private static int getPivotIndex(int[] a,int start, int end) {
		swap(a,start, getRandomInt(start, end));

		int pivotIdx = start;
		int l = start; int h = end;

		while(l < h) {
			while(a[h] > a[pivotIdx]) {
				h--;
			}

			while(l < h && a[l] <= a[pivotIdx]) {
				l++;
			}
			swap(a,l,h);
		}
		swap(a,pivotIdx, l);
		return l;
	}

	private static int getRandomInt(int start, int end) {
		if(start == end) return start;
		int offset = end-start;
		return random.nextInt(offset)+start;
	}

	private static void swap(int[] a,int n1, int n2) {
	    int temp = a[n1];
	    a[n1] = a[n2];
	    a[n2] = temp;
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

	public void close() throws IOException {
		br.close();
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
