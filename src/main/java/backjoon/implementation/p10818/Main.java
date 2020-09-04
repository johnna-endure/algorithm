package backjoon.implementation.p10818;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 10818번 - 최소, 최대
https://www.acmicpc.net/problem/10818
 */
public class Main {
	static int N, INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));

		N = Integer.parseInt(br.readLine());

		int min = INF;
		int max = -INF;

		int n = 0;
		int sign = 1;
		while(br.ready()) {
			char c = (char)br.read();

			if(c == '-') {
				sign = -1;
			}

			if (c >= '0' && c <= '9') {
				n = 10*n + (c-'0');
			}

			if (c == ' '){
				n *= sign;
				min = Math.min(min, n);
				max = Math.max(max, n);

				n = 0;
				sign = 1;
			}
		}

		n *= sign;
		min = Math.min(min, n);
		max = Math.max(max, n);

		System.out.println(min + " " + max);
	}
}
