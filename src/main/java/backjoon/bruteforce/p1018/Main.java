package backjoon.bruteforce.p1018;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	static char[][] board;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = reader.readLine().toCharArray();
		}

		System.out.println(makeChessBoard(board));
	}
	/*
	체스판을 만들면서 칠해야하는 직사각형의 최소 개수를 반환
	 */
	private static int makeChessBoard(char[][] board) {
		int min = INF;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if(isRange(row, col, board.length, board[row].length))
					min = Math.min(paint(row, col, board), min);
			}
		}
		return min;
	}

	private static boolean isRange(int row, int col, int rowLength, int colLength) {
		if(row+8 > rowLength || col+8 > colLength) return false;
		return true;
	}

	private static int paint(int row, int col, char[][] board) {
		int whiteCase = 0;
		int blackCase = 0;
		
		for (int i = row; i < row+8; i++) {
			for (int j = col; j < col+8; j++) {
				if((i+j)%2 == 0) {
					if(board[i][j] != 'B') blackCase++;
					if(board[i][j] != 'W') whiteCase++;
				}else {
					if(board[i][j] != 'W') blackCase++;
					if(board[i][j] != 'B') whiteCase++;
				}
			}
		}
//		System.out.printf("startRow : %d, startCol : %d, bcCnt : %d, wcCnt : %d\n", row, col,blackCase,whiteCase);
		return Math.min(blackCase, whiteCase);
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