package backjoon.implementation.p12100;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*
백준 12100번 - 2048(Easy)
https://www.acmicpc.net/problem/12100
 */
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();

		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solve( 0, 0, board));
	}

//	static int invoke = 0;
	private static int solve(int count, int maxVal,int[][] board) {
		if(count == 5) return maxVal;

		int ret = 0;
		//수정하기 전에 복구를 위해 복사
		int[][] copyBoard = new int[n][n];
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				copyBoard[j][k] = board[j][k];
			}
		}

		// 0:상, 1:하, 2:우, 3:좌
		for (int i = 0; i < 4; i++) {
			int max = move(i, board);
			ret = Math.max(solve(count+1, max, board), ret);

			//복구
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					board[j][k] = copyBoard[j][k];
				}
			}
		}
		return ret;
	}
	/*
	방향으로 블록들을 이동
	 */
	public static int move(int direction, int[][] board) {
		int n = board.length;
		int maxVal = 0;
		//위로 이동. 아래로 스캔
		if(direction == 0) {
			for (int col = 0; col < n; col++) {
				List<Integer> line = scanOneColumn(col, true,board);
				List<Integer> newLine = mergeSameNumber(line);
				maxVal = Math.max(updateOneColumn(col,true, newLine, board), maxVal);
			}
		}
		//아래. 위로 스캔
		if(direction == 1) {
			for (int col = 0; col < n; col++) {
				List<Integer> line = scanOneColumn(col, false, board);
				List<Integer> newLine = mergeSameNumber(line);
				maxVal = Math.max(updateOneColumn(col,false, newLine, board), maxVal);
			}
		}
		//우. 왼쪽으로 스캔
		if(direction == 2) {
			for (int row = 0; row < n; row++) {
				List<Integer> line = scanOneRow(row, false, board);
				List<Integer> newLine = mergeSameNumber(line);
				maxVal = Math.max(updateOneRow(row,false, newLine, board), maxVal);
			}
		}
		//좌. 오른쪽으로 스캔
		if(direction == 3) {
			for (int row = 0; row < n; row++) {
				List<Integer> line = scanOneRow(row, true, board);
				List<Integer> newLine = mergeSameNumber(line);
				maxVal = Math.max(updateOneRow(row,true, newLine, board), maxVal);
			}
		}
		return maxVal;
	}

	public static int updateOneRow(int row, boolean isRight, List<Integer> line, int[][] board) {
		int n = board.length;
		int maxVal = 0;
		if(isRight) {
			for (int col = 0; col < n; col++) {
				board[row][col] = line.get(col);
				maxVal = Math.max(maxVal, board[row][col]);
			}
		}else {
			for (int col = 0; col < n; col++) {
				board[row][n-col-1] = line.get(col);
				maxVal = Math.max(maxVal, board[row][n-col-1]);
			}
		}
		return maxVal;
	}

	public static int updateOneColumn(int col, boolean isDown, List<Integer> line, int[][] board) {
		int n = board.length;
		int maxVal = 0;
		if(isDown) {
			for (int row = 0; row < n; row++) {
				board[row][col] = line.get(row);
				maxVal = Math.max(maxVal, board[row][col]);
			}
		}else {
			for (int row = 0; row < n; row++) {
				board[n-row-1][col] = line.get(row);
				maxVal = Math.max(maxVal, board[n-row-1][col]);
			}
		}
		return maxVal;
	}

	public static List<Integer> mergeSameNumber(List<Integer> line) {
		int n = line.size();
		//먼저 빈칸 제거
		line = line.stream().filter(e -> e != 0).collect(Collectors.toList());
		int size = line.size();
		for (int i = 0; i < size; i++) {
			if(i < size-1 && line.get(i).intValue() == line.get(i+1).intValue()) {
				line.set(i, line.get(i)*2);
				line.remove(i+1);
				size = line.size();
			}
		}

		while(line.size() < n) {
			line.add(0);
		}
		return line;
	}

	public static List<Integer> scanOneRow(int row, boolean isRight, int[][] board) {
		int n = board.length;
		List<Integer> l = new ArrayList<>();
		if(isRight) {
			for (int col = 0; col < n; col++) {
				l.add(board[row][col]);
			}
		} else {
			for (int col = n-1; col >= 0; col--) {
				l.add(board[row][col]);
			}
		}
		return l;
	}

	public static List<Integer> scanOneColumn(int col, boolean isDown, int[][] board) {
		int n = board.length;
		List<Integer> l = new ArrayList<>();
		if(isDown) {
			for (int row = 0; row < n; row++) {
				l.add(board[row][col]);
			}
		} else {
			for (int row = n-1; row >= 0; row--) {
				l.add(board[row][col]);
			}
		}
		return l;
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
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}
