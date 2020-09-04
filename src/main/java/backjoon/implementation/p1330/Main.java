package backjoon.implementation.p1330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1330번 - 두 수 비교하기
https://www.acmicpc.net/problem/1330
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());

		print(left, right);
	}

	public static void print(int left, int right) {
		if(left > right) System.out.println(">");
		else if(left < right) System.out.println("<");
		else System.out.println("==");
	}
}
