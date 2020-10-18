package backjoon.backtracking.p9663;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
N-Queen
 */
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		List<Location> queenLocations = new ArrayList<>();

//		for (int i = 0; i < n; i++) {
//			nQueen()
//		}

		System.out.println(nQueen(0,0,queenLocations));
	}

	private static int nQueen(int row, int queen, List<Location> queenLocations) {
		if(queen == n) return 1;

		int ret = 0;

		for (int i = 0; i < n; i++) {
			if(isValid(row, i, queenLocations)) {
				queenLocations.add(new Location(row, i));

				ret += nQueen(row+1, queen+1, queenLocations);
				queenLocations.remove(queenLocations.size()-1);
			}
		}
		return ret;
	}

	private static boolean isValid(int row, int col, List<Location> queenLocations) {
		for (int i = 0; i < queenLocations.size(); i++) {
			Location location = queenLocations.get(i);
			if(location.row == row || location.col == col
					|| location.row + location.col == row + col
					|| location.row - location.col == row - col) return false;
		}
		return true;
	}
}
class Location {
	int row, col;
	public Location (int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "{row=" + row +
				", col=" + col +
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
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}
