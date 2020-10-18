package backjoon.segmenttree.p2357;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Function;

/*
최솟값과 최댓값
https://www.acmicpc.net/problem/2357
 */
public class Main {
	static int n,m;
	static int[] nums;
	static long[] minSegments;
	static long[] maxSegments;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nums = new int[n+1];
		minSegments = new long[4*n+1];
		maxSegments = new long[4*n+1];
		for (int i = 1; i <= n; i++) { nums[i] = reader.readInt(); }

		initSegments(1,n,1,minSegments, (a,b) -> Math.min(a,b)); //최소값 구간 초기화
		initSegments(1,n,1,maxSegments, (a,b) -> Math.max(a,b)); //최대값 구간 초기화

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int left = Integer.parseInt(st.nextToken()); int right = Integer.parseInt(st.nextToken());

			System.out.println(queryMin(left,right,1,n,1) + " "
					+ queryMax(left,right,1,n,1));
		}
	}

	private static long initSegments(int left, int right, int segmentIndex,
	                                 long[] segments, BiFunction<Long, Long, Long> f) {
		if(left == right) return segments[segmentIndex] = nums[left];

		int mid = (left + right)/2;
		long leftVal = initSegments(left, mid, 2*segmentIndex, segments, f);
		long rightVal = initSegments(mid+1, right, 2*segmentIndex+1, segments, f);

		return segments[segmentIndex] = f.apply(leftVal, rightVal);
	}

	private static long queryMin(int queryLeft, int queryRight,
	                          int segmentLeft, int segmentRight, int segmentIndex) {
		//겹치지 않는 경우
		if(segmentRight < queryLeft || queryRight < segmentLeft) return Long.MAX_VALUE;
		//완전히 포함되는 경우
		if(queryLeft <=  segmentLeft && segmentRight <= queryRight) return minSegments[segmentIndex];

		//걸치는 경우
		int mid = (segmentLeft + segmentRight)/2;
		long leftVal = queryMin(queryLeft, queryRight, segmentLeft, mid, segmentIndex*2);
		long rightVal = queryMin(queryLeft, queryRight, mid+1, segmentRight, segmentIndex*2+1);

		return Math.min(leftVal, rightVal);
	}

	private static long queryMax(int queryLeft, int queryRight,
	                             int segmentLeft, int segmentRight, int segmentIndex) {
		//겹치지 않는 경우
		if(segmentRight < queryLeft || queryRight < segmentLeft) return Long.MIN_VALUE;
		//완전히 포함되는 경우
		if(queryLeft <=  segmentLeft && segmentRight <= queryRight) return maxSegments[segmentIndex];

		//걸치는 경우
		int mid = (segmentLeft + segmentRight)/2;
		long leftVal = queryMax(queryLeft, queryRight, segmentLeft, mid, segmentIndex*2);
		long rightVal = queryMax(queryLeft, queryRight, mid+1, segmentRight, segmentIndex*2+1);

		return Math.max(leftVal, rightVal);
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
