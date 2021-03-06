package backjoon.implementation.p1913;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
달팽이
https://www.acmicpc.net/problem/1913
 */
public class Main {
	static int n, target;
	static int[][] snail;
	static Point targetPosition;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		target = reader.readInt();
		snail = new int[n][n];

		makeSnail(snail);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(snail[i][j]);
				if(j != n-1) sb.append(" ");
				if(j == n-1) sb.append("\n");
			}
		}
		sb.append((targetPosition.row+1) + " " + (targetPosition.col+1));
		System.out.println(sb.toString());
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int number = 1;
	private static void makeSnail(int[][] snail) {
		int row = n/2; int col = n/2;
		snail[row][col] = 1;
		int length = 1; int dirIdx = 0;
		while(true) {
			//수직방향
			for (int i = 0; i < length; i++) {
				row += dr[dirIdx]; col += dc[dirIdx];
				snail[row][col] = incrementNumber(row, col);
			}
			dirIdx = (dirIdx+1)%4;
			//수방향
			for (int i = 0; i < length; i++) {
				row += dr[dirIdx]; col += dc[dirIdx];
				snail[row][col] = incrementNumber(row, col);
			}
			dirIdx = (dirIdx+1)%4;
			if(length == n-1) break;
			length++;
		}

		//마지막 처리
		for (int i = 0; i < length; i++) {
			row += dr[0]; col += dc[0];
			snail[row][col] = incrementNumber(row, col);
		}
	}
	public static int incrementNumber(int row, int col) {
		int nextN = ++number;
		if(nextN == target) targetPosition = new Point(row, col);
		return nextN;
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