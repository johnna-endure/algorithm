package backjoon.implementation.p2163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2163번 - 초콜릿 자르기
https://www.acmicpc.net/problem/2163
 */
public class Main {
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		System.out.println(n*m-1);
	}
}
