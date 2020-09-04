package backjoon.implementation.p2446;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2446번 - 별 찍기9
https://www.acmicpc.net/problem/2446
 */
public class Main {
	static int n;
	static int length;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		n = Integer.parseInt(br.readLine());
		length = 2*n-1;

		solve();
	}

	private static void solve() {
		int head = 0; int tail = length-1;
		StringBuilder sb = new StringBuilder();
		while(head != tail) {
			sb.append(getStarRow(head, tail));
			head++; tail--;
		}

		while(!(head < 0 && tail > length-1)) {
			sb.append(getStarRow(head, tail));
			head--; tail++;
		}

		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	// n이 주어질 때 2n-1 길이의 *로 이루어진 문자열 반환
	private static String getStarRow(int head, int tail) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= tail; i++) {
			if(i >= head && i <= tail) {
				sb.append("*");
				continue;
			}
			sb.append(" ");
		}
		return sb.toString()+"\n";
	}

}
