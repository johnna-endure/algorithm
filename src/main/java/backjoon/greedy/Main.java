package backjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Period[] periods;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		periods = new Period[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			periods[i] = new Period(start, end);
		}
		Comparator<Period> comparatorEnd = Comparator.comparingLong(p1 -> p1.end);
		Comparator<Period> comparatorStart = Comparator.comparingLong(p1 -> p1.start);
		Arrays.sort(periods, comparatorEnd.thenComparing(comparatorStart));
//		System.out.println(Arrays.toString(periods));
		int ret = solve();
		System.out.println(ret);
	}

	private static int solve() {
		long lastEnd=0;
		int cnt = 0;
		for (int i = 0; i < periods.length; i++) {
			if(periods[i].start >= lastEnd) {
				cnt ++;
				lastEnd = periods[i].end;
			}
		}

		return cnt;
	}
}
class Period {
	long start, end;
	public Period(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "start=" + start +
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

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
}

