package backjoon.string.p5397;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
키로거
https://www.acmicpc.net/problem/5397
 */
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		for (int i = 0; i < n; i++) {
			String keyLog = reader.readLine().trim();
			System.out.println(getPassword(keyLog));
		}
	}

	private static String getPassword(String keyLog) {
		ArrayDeque<Character> password = new ArrayDeque<>();
		ArrayDeque<Character> temp = new ArrayDeque<>();

		for (int i = 0; i < keyLog.length(); i++) {
			char log = keyLog.charAt(i);

			switch (log) {
				case '<' : {
					if(!password.isEmpty()) {
						temp.addFirst(password.pollLast());
					}
					break;
				}
				case '>': {
					if(!temp.isEmpty()) {
						password.addLast(temp.pollFirst());
					}
					break;
				}
				case '-' : {
					if(!password.isEmpty()) {
						password.pollLast();
					}
					break;
				}
				default:{
					password.addLast(log);
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		while(!password.isEmpty()) {
			sb.append(password.pollFirst());
		}

		while(!temp.isEmpty()) {
			sb.append(temp.pollFirst());
		}

		return sb.toString();
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
