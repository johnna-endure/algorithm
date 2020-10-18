package backjoon.implementation.p2960;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
에라토스테네스의 체
https://www.acmicpc.net/problem/2960
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] numbers = new boolean[n+1];
		Arrays.fill(numbers, true);

		System.out.println(erathosthenes(k,n,numbers));
	}

	public static int erathosthenes(int k, int n, boolean[] numbers) {
		numbers[0] = false;
		numbers[1] = false;
		int cnt = 0;

		for (int start = 2; start <= n; start++) {
			if(numbers[start]){
				for (int i = start; i <= n; i+=start) {
					if(numbers[i]) {
						numbers[i] = false;
						cnt++;
						if(cnt == k) return i;
					}
				}
			}
		}

		return -1;
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
