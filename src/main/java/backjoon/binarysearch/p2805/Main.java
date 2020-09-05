package backjoon.binarysearch.p2805;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
백준 2805번 - 나무 자르기
https://www.acmicpc.net/problem/2805
 */
public class Main {
	static int n;
	static long m;
	static int[] trees;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());

		trees = new int[n];
		st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()) {
			trees[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		Arrays.sort(trees);
//		System.out.println(Arrays.toString(trees));

		int ret = solve(trees);
		System.out.println(ret);
	}

	private static int solve(int[] trees) {
		return getCuttingHeight(0, trees[trees.length-1], m);
//		return 0;
	}

	public static int getCuttingHeight(int low, int high, long needWoods){
		int mid = (low+high)/2;
		long slicedWoods = slice(mid);
//		System.out.format("low : %d, high : %d, mid : %d, sliced : %d, target : %d\n", low, high, mid, slicedWoods, needWoods);

		if(low == high) {
			if(slicedWoods < needWoods) return low-1;
			return low;
		}

		if(slicedWoods > needWoods) {
			return getCuttingHeight(mid+1, high, needWoods);
		} else if(slicedWoods == needWoods) {
			return mid;
		} else {
			return getCuttingHeight(low, mid, needWoods);
		}
	}

	private static long slice(int h) {
		long sum = 0;
		for (int i = n-1; i >= 0; i--) {
			if(trees[i] > h) sum += trees[i] - h;
			else break;
		}
		return sum;
	}
}
