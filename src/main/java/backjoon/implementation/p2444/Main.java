package backjoon.implementation.p2444;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
백준 2444번 - 별 찍기 7
https://www.acmicpc.net/problem/2444
 */
public class Main {
	static int n, max_l;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		n = Integer.parseInt(br.readLine());
		max_l = 2*n-1;
		printStart();
	}

	private static void printStart() {
		StringBuilder sb = new StringBuilder();
		int head = max_l/2; int tail = max_l/2;

		while(head > 0 && tail < max_l-1) {
			sb.append(createStarRow(head, tail));
			head--; tail++;
		}

		head = 0; tail = max_l-1;
		while(true) {
			sb.append(createStarRow(head, tail));
			if(head == tail) break;
			head++; tail--;
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
		return sb.append("\n").toString();
	}



}
