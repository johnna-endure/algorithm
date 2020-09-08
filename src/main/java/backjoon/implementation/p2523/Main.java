package backjoon.implementation.p2523;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
백준 2523번 - 별 찍기 13
 */
public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		printStar();
	}

	private static void printStar() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(createStarRow(i));
		}

		for (int i = n-1; i > 0; i--) {
			sb.append(createStarRow(i));
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String createStarRow(int row) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row; i++) {
			sb.append("*");
		}
		return sb.append("\n").toString();
	}


}
