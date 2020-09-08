package backjoon.implementation.p2455;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2455번 - 지능형 기차
https://www.acmicpc.net/problem/2455
 */
public class Main {
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		int total = 0;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());

			total -= out;
			total = total+in > 10000 ? 10000 : total+in;
			max = Math.max(max, total);

		}
		System.out.println(max);
	}
}
