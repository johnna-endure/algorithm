package backjoon.sort.p1946;

import java.io.*;
import java.util.*;

public class Main {
	static int T,N;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		T = reader.readInt();
		for (int tc = 0; tc < T; tc++) {
			N = reader.readInt();
			List<Point> applicant = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				applicant.add(new Point(y, x));
			}

			applicant.sort(Comparator.comparingInt(point -> point.x));
			int ret = solve(applicant);
			System.out.println(ret);
		}
	}

	private static int solve(List<Point> applicant) {
		List<Point> stack = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			Point point = applicant.get(i);
			if(!hasInnerPoint(applicant.get(i), stack)) {
				stack.add(point);
			}
		}
		return stack.size();
	}

	private static boolean hasInnerPoint(Point point, List<Point> stack) {
		if(stack.isEmpty()) return false;
		Point top = stack.get(stack.size()-1);
		if(top.y < point.y) return true;
		return false;
	}
}
class Point {
	int y, x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
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