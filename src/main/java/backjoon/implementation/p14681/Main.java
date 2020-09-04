package backjoon.implementation.p14681;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 14681번 - 사분면 고르기
https://www.acmicpc.net/problem/14681
 */
public class Main {
	static int x,y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));

		x = Integer.parseInt(br.readLine());
		y = Integer.parseInt(br.readLine());

		int ret = solve(x,y);
		System.out.println(ret);
	}

	private static int solve(int x, int y) {
		if(x >= 0) {
			if(y >= 0) return 1;
			else return 4;
		}else {
			if(y >= 0) return 2;
			else return 3;
		}
	}
}
