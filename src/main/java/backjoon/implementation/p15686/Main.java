package backjoon.implementation.p15686;

import java.io.*;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

/*
백준 15696번 - 치킨 배달
https://www.acmicpc.net/problem/15686
 */
public class Main {
	static int[][] map;
	static int n,m, INF=987654321;
	static List<Point> chickenPlaces = new ArrayList<>();
	static List<Point> houses = new ArrayList<>();
	static Set<Integer> selectedStatusSet = new HashSet<>();
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

		map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) houses.add(new Point(i,j));
				if(map[i][j] == 2) chickenPlaces.add(new Point(i,j));
			}
		}
		selectChickenPlace(0,0,0);

		int ret = selectedStatusSet.stream()
				.mapToInt(status -> houses.stream()
						.mapToInt(house -> getShortestDistance(house, status))
						.sum())
				.min().getAsInt();

		System.out.println(ret);

	}


	private static void selectChickenPlace(int start, int count, int selected) {
		if(count == m) selectedStatusSet.add(selected);
		if(start == chickenPlaces.size()) return;

		for (int i = start; i < chickenPlaces.size(); i++) {
			//선택한 경우
			selectChickenPlace(i+1, count+1, selected | (1 << i));
			//선택하지 않은 경우
			selectChickenPlace(i+1, count, selected);
		}
	}

	private static int getShortestDistance(Point house, int selectedStatus) {
		int min = INF;
		for (int i = 0; i < chickenPlaces.size(); i++) {
			if((selectedStatus & (1 << i)) != 0) {
				int dr = Math.abs(chickenPlaces.get(i).row - house.row);
				int dc = Math.abs(chickenPlaces.get(i).col - house.col);
				min = Math.min(min, dr+dc);
			}
		}
		return min;
	}

}

class Point {
	int row, col;
	public Point(int row, int col) {
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
}

