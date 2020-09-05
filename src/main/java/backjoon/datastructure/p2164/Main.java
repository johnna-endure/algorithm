package backjoon.datastructure.p2164;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
백준 2164번 - 카드2
https://www.acmicpc.net/problem/2164
 */
public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		n = Integer.parseInt(br.readLine());

		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while(q.size() != 1) {
			q.pollFirst();
			int transfer = q.pollFirst();
			q.addLast(transfer);
		}

		System.out.println(q.poll());
	}
}
