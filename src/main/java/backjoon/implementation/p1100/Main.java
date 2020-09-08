package backjoon.implementation.p1100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
백준 1100번 - 하얀 칸
https://www.acmicpc.net/problem/1100
 */
public class Main {
	static String[] board = new String[8];
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 8; i++) {
			board[i] = br.readLine();
		}

		int ret = solve();
		System.out.println(ret);
	}

	private static int solve() {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if((i+j)%2 == 0 && board[i].charAt(j) == 'F') cnt++;
			}
		}
		return cnt;
	}
}
