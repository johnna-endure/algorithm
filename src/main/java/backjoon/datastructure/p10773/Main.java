package backjoon.datastructure.p10773;

import java.io.*;
import java.util.Stack;

/*
백준 10773 - 제로
https://www.acmicpc.net/problem/10773
 */
public class Main {
	static int k;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				stack.pop(); continue;
			}
			stack.push(n);
		}
		long sum = 0;

		while(!stack.empty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
