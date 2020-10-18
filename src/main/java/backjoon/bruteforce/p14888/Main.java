package backjoon.bruteforce.p14888;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
연산자 끼워넣기
https://www.acmicpc.net/problem/14888
0 : +, 1 : -, 2 : *, 3 : /
 */
public class Main {
	static int n;
	static int[] numbers, operatorCnt;
	public static void main (String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		operatorCnt = new int[4];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < 4; i++) {
			operatorCnt[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(getMax(0, numbers[0]));
		System.out.println(getMin(0, numbers[0]));

	}
	private static int getMin(int idx, int sum) {
		if(idx == n-1) return sum;

		int ret = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			if(operatorCnt[i] > 0) {
				int nextSum = calc(sum, numbers[idx+1], i);
				operatorCnt[i]--;
				ret = Math.min(getMin(idx+1, nextSum), ret);
				operatorCnt[i]++;
			}
		}
		return ret;
	}

	public static int getMax(int idx, int sum) {
		if(idx == n-1) return sum;

		int ret = Integer.MIN_VALUE;

		for (int i = 0; i < 4; i++) {
			if(operatorCnt[i] > 0) {
				int nextSum = calc(sum, numbers[idx+1], i);
				operatorCnt[i]--;
				ret = Math.max(getMax(idx+1, nextSum), ret);
				operatorCnt[i]++;
			}
		}
		return ret;
	}

	public static int calc(int a, int b, int op) {
		int ret = 0;
		if(op == 0) {
			ret = a+b;
		}

		if(op == 1) {
			ret = a-b;
		}

		if(op == 2) {
			ret = a*b;
		}

		if(op == 3) {
			ret = a/b;
			if(a*b < 0) ret = -(Math.abs(a) / Math.abs(b));
		}
		return ret;
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