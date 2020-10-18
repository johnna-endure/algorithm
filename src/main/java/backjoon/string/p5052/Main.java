package backjoon.string.p5052;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
전화번호 목록
https://www.acmicpc.net/problem/5052
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		int t = reader.readInt();
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < t; testcase++) {
			int n = reader.readInt();
			List<String> numbers = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				numbers.add(reader.readLine());
			}

			numbers.sort(Comparator.naturalOrder());
			boolean isConsistent = true;
			for (int i = 0; i < numbers.size()-1; i++) {
				if(numbers.get(i+1).startsWith(numbers.get(i))) {
					isConsistent = false;
				}
			}
			String ret = isConsistent ? "YES" : "NO";
			sb.append(ret+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}
class InputReader {
	private BufferedReader br;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public InputReader(String filepath) {
		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public boolean ready() throws IOException {
		return br.ready();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}