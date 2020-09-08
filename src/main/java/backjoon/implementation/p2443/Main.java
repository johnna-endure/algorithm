package backjoon.implementation.p2443;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
백준 2443 - 별 찍기 6
https://www.acmicpc.net/problem/2443
 */
public class Main {
	static int n, max_l;
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		n = Integer.parseInt(br.readLine());
		max_l = 2*n-1;

		solve();
	}

	private static void solve() {
		StringBuilder sb = new StringBuilder();

		int head=0; int tail=max_l-1;
		while(true) {
			sb.append(createRow(head, tail));
			if(head == tail) break;
			head++; tail--;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String createRow(int head, int tail) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= tail; i++) {
			if(i >= head) {
				sb.append("*"); continue;
			}
			sb.append(" ");
		}
		return sb.append("\n").toString();
	}
}
