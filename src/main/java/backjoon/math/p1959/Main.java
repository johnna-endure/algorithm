package backjoon.math.p1959;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
달팽이3
https://www.acmicpc.net/problem/1959
 */
public class Main {
	static long m,n;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		StringTokenizer st = new StringTokenizer(reader.readLine());
		m = Long.parseLong(st.nextToken());
		n = Long.parseLong(st.nextToken());

		long smallerValue = Math.min(m,n);
		long quotient = smallerValue / 2;
		m -= quotient*2; n -= quotient*2;
		if(m == 0 || n == 0) {
			quotient--;
			m += 2; n += 2;
		}

		long curveCnt = 4*quotient + lastSnail(m,n);
		int row = 1; int col = 1;
		row += quotient; col += quotient;
		if(m == 2 || n == 2) {
			row++;
		}
		if(m == 1) {
			col += n-1;
		}
		if(n == 1){
			row += m-1;
		}

		System.out.println(curveCnt);
		System.out.println(row + " " + col);
	}

	private static long lastSnail(long m, long n) {
		if(m == 2) return 2;
		if(n == 2) return 3;

		if(m == 1) return 0;
		if(n == 1) return 1;

		return 0;
	}
}
class Point {
	int row, col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
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