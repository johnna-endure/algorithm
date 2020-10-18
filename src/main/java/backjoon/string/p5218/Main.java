package backjoon.string.p5218;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
알파벳 거리
https://www.acmicpc.net/problem/5218
 */
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			String a = st.nextToken(); String b = st.nextToken();
			List<Integer> dist = calcDistance(a,b);
			sb.append("Distances: ");
			for (int j = 0; j < dist.size(); j++) {
				sb.append(dist.get(j));
				if(j != dist.size()-1) sb.append(" ");
				if(j == dist.size()-1) sb.append("\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static List<Integer> calcDistance(String a, String b) {
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			int ac = a.charAt(i)-64;
			int bc = b.charAt(i)-64;
			if(bc >= ac) ret.add(bc-ac);
			else ret.add(bc+26-ac);
		}

		return ret;
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