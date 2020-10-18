package backjoon.implementation.p1952;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
달팽이2
https://www.acmicpc.net/problem/1952
 */
public class Main {
	static int m,n;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[m][n];

		System.out.println(countCurvePoint());
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	private static int countCurvePoint() {
		int curvePoint = 0;
		int dirIdx = 0;
		int row = 0; int col = 0;
		visited[row][col] = true;
		while(true) {
			//이동
			int nextR = row+dr[dirIdx];
			int nextC = col+dc[dirIdx];
			while(isRange(nextR, nextC) && !visited[nextR][nextC]) {
				visited[nextR][nextC] = true;
				row = nextR; col = nextC;
				nextR = row+dr[dirIdx]; nextC = col+dc[dirIdx];
			}

			dirIdx =(dirIdx+1)%4;
			//다음 방향 바로 앞칸이 방문된 경우 종료
			if(visited[row+dr[dirIdx]][col+dc[dirIdx]]) break;
			curvePoint++;
		}
		return curvePoint;
	}

	private static boolean isRange(int row, int col) {
		if(row < 0 || row >= m || col < 0 || col >= n) return false;
		return true;
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