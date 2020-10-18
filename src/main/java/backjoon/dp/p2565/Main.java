package backjoon.dp.p2565;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
	static int n;
	static List<Link> links = new ArrayList<>();
	static int[] cache;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();
		n = reader.readInt();
		cache = new int[501];
		Arrays.fill(cache, -1);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			links.add(Link.create(u,v));
		}

//		links.sort(Comparator.comparingInt(link -> link.start));

		int ret = 0;
		for (int i = 0; i < n; i++) {
			ret = max(lis(i), ret);
		}
		System.out.println(n-ret);
	}

	private static int lis(int index) {
		Link currentLink = links.get(index);
		if(cache[index] != -1) return cache[index];

		int ret = 1;
		for (int i = index+1; i < n; i++) {
			Link otherLink = links.get(i);
			if(currentLink.end < otherLink.end) {
				ret = max(lis(i)+1, ret);
			}
		}
		return cache[index] = ret;
	}

}
class Link {
	int start, end;
	private Link(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public static Link create(int start, int end) {
		return new Link(start, end);
	}

	@Override
	public String toString() {
		return "Link{" +
				"start=" + start +
				", end=" + end +
				'}';
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