package backjoon.implementation.p2442;

import java.io.*;

/*
백준 2442번 - 별 찍기 5
 */
public class Main {
	static int n, max_l;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));

		n = Integer.parseInt(br.readLine());
		max_l = 2*n-1;
		
		solve();
	}

	private static void solve() {
		int mid = (max_l-1)/2;
		StringBuilder sb = new StringBuilder();
		int head = mid; int tail = mid;
		while(head >= 0 && tail <= max_l-1) {
			String row = createStarRow(head, tail);
			sb.append(row);
			head--; tail++;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String createStarRow(int head, int tail) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= tail; i++) {
			if(i >= head) {
				sb.append("*"); continue;
			}
			sb.append(" ");
		}
		return sb.toString()+"\n";
	}

}
