package backjoon.string.p1543;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
문서 검색
https://www.acmicpc.net/problem/1543
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		String text = reader.readLine();
		String targetString = reader.readLine();

		int cnt = 0;
		for (int i = 0; i+targetString.length() <= text.length(); i++) {
			if(text.startsWith(targetString, i)) {
				cnt++;
				i += targetString.length()-1;
			}
		}
		System.out.println(cnt);
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