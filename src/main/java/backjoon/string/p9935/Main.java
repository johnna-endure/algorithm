package backjoon.string.p9935;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
문자열 폭발
https://www.acmicpc.net/problem/9935
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");

		List<Character> entire = reader.readLineIntoCharList();
		List<Character> explode = reader.readLineIntoCharList();

		char last_explode = explode.get(explode.size()-1);

		List<Character> stack = new ArrayList<>();
		for (int i = 0; i < entire.size(); i++) {
			stack.add(entire.get(i));
			if(i >= explode.size()-1 && entire.get(i) == last_explode) {
				if(isExplodeString(stack, explode)) {
					for (int j = 0; j < explode.size(); j++) {
						stack.remove(stack.size()-1);
					}
				}
			}
		}
		if (stack.size() == 0) {
			System.out.println("FRULA"); return;
		}else {
			StringBuilder sb = new StringBuilder();
			for (char c : stack) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}

	public static boolean isExplodeString(List<Character> stack, List<Character> explode) {
		for (int i = 0; i < explode.size(); i++) {
			if(explode.get(explode.size()-1-i) != stack.get(stack.size()-1-i)) return false;
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
