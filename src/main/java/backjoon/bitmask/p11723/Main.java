package backjoon.bitmask.p11723;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int m, S=0;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		m = reader.readInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			String command = st.nextToken();
			if(st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if(command.equals("add")) {
					add(n);
				}
				if(command.equals("remove")) {
					remove(n);
				}
				if(command.equals("check")) {
					sb.append(check(n) + "\n");
				}
				if(command.equals("toggle")) {
					toggle(n);
				}
			}
			if(command.equals("all")) {
				all();
			}
			if(command.equals("empty")) {
				empty();
			}
		}
		if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void empty() {
		S = 0;
	}

	private static void all() {
		S = (1 << 20) - 1;
	}

	private static void toggle(int n) {
		if(check(n) == 0) add(n);
		else remove(n);
	}

	private static int check(int n) {
		if((S & (1 << n-1)) == 0) return 0;
		return 1;
	}

	private static void remove(int n) {
		int all = (1 << 20)-1;
		int comp = all ^ (1 << n-1);
		S &= comp;
	}

	private static void add(int n) {
		S |= (1 << n-1);
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
