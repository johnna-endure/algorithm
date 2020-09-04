package backjoon.implementation.p2562;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/*
백준 2562번 - 최댓값
https://www.acmicpc.net/problem/2562
 */

public class Main {
	static List<Number> numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		numbers = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			Number n = new Number(i, Integer.parseInt(br.readLine()));
			numbers.add(n);
		}
		Comparator<Number> comparator = (n1, n2) -> n1.n - n2.n;
		numbers.sort(comparator.reversed());
		System.out.println(numbers.get(0).n);
		System.out.println(numbers.get(0).order+1);
	}
}
class Number {
	int order;
	int n;

	public Number(int order, int n) {
		this.order = order;
		this.n = n;
	}

	@Override
	public String toString() {
		return "Number{" +
				"order=" + order +
				", n=" + n +
				'}';
	}
}
