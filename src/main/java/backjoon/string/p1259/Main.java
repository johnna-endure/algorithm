package backjoon.string.p1259;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
팰린드롬수
https://www.acmicpc.net/problem/1259
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();

		StringBuilder sb = new StringBuilder();
		while(true) {
			String input = reader.readLine();
			if(input.equals("0")) break;

			if(isPalindrom(input)) sb.append("yes\n");
			else sb.append("no\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static boolean isPalindrom(String input) {
		char[] ca = input.toCharArray();
		int start = 0; int end = input.length()-1;
		while (start < end) {
			if(ca[start] != ca[end]) return false;
			start++; end--;
		}
		return true;
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

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
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
