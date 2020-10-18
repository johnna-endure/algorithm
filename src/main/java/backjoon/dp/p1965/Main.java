package backjoon.dp.p1965;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] box, cache;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		box = new int[n];
		cache = new int[n]; Arrays.fill(cache, -1);
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		int ret = 0;
		for (int i = 0; i < n; i++) {
			ret = Math.max(lis(i), ret);
		}
		System.out.println(ret);
	}

	private static int lis(int index) {
		if(cache[index] != -1) return cache[index];

		int ret = 1;
		for (int i = index+1; i < n; i++) {
			if(box[index] < box[i]) {
				ret = Math.max(lis(i)+1, ret);
			}
		}
		return cache[index] = ret;
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
