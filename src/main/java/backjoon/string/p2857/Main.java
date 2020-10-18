package backjoon.string.p2857;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
FBI
https://www.acmicpc.net/problem/2857
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			String name = reader.readLine();
			if(name.contains("FBI")) sb.append(i+1 + " ");
		}
		if(sb.length() == 0) {
			System.out.println("HE GOT AWAY!");
			return;
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