package backjoon.string.kmp.p1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
KMP 알고리즘
문제 이름 : 찾기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();

		KMPReader reader = new KMPReader(text, pattern);
		List<Integer> ret = reader.search();
		System.out.println(ret.size());
		ret.stream().forEach(i -> System.out.println(i+1));
	}
}
