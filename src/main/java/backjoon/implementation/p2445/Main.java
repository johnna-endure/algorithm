package backjoon.implementation.p2445;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
백준 2445번 - 별 찍기 8
https://www.acmicpc.net/problem/2445
 */
public class Main {
	static int n, max_l;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		n = Integer.parseInt(br.readLine());
		max_l = 2*n;

		solve();
	}

	private static void solve() {
		StringBuilder sb = new StringBuilder();
		
		int head = 0; int tail = max_l-1;
		while(head < tail) {
			sb.append(createRow(head, tail));
			head++; tail--;
		}

		head = (max_l-1)/2-1; tail = (max_l-1)/2+2;
		while(head >= 0 && tail <= max_l-1) {
			sb.append(createRow(head, tail));
			head--; tail++;
		}

		System.out.println(sb.toString());
	}

	private static String createRow(int head, int tail) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max_l; i++) {
			if(i > head && i < tail) {
				sb.append(" "); continue;
			}
			sb.append("*");
		}
		return sb.append("\n").toString();
	}


}
