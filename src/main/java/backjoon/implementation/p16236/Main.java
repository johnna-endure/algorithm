package backjoon.implementation.p16236;

import java.io.*;
import java.util.*;

/*
아기 상어
https://www.acmicpc.net/problem/16236
 */
public class Main {
	static int n;
	static int[][] sea;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		sea = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Point start = findStartPoint();
		Shark shark = new Shark(start);
		int totalTime = 0;
		while(true){
			int passedTime = shark.huntFish(sea);
			if(passedTime == -1) break;
			totalTime += passedTime;
		}

		System.out.println(totalTime);
	}

	private static Point findStartPoint() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(sea[i][j] == 9) return Point.create(i,j);
			}
		}
		throw new RuntimeException("no sharks.");
	}

}
class Shark {
	private int[] dr = {-1,0,0,1};
	private int[] dc = {0,-1,1,0};
	private SharkSize size;
	private Point sharkPoint;
	public Shark(Point startPosition) {
		this.sharkPoint = startPosition;
		this.size = new SharkSize();
	}
	/*
	먹을 수 있는 가장 가까운 물고기를 찾는다.
	 */
	public int huntFish(int[][] sea) {
		boolean[][] discovered = new boolean[sea.length][sea.length];
		int[][] passedTime = new int[sea.length][sea.length];

		discovered[sharkPoint.row][sharkPoint.col] = true;
		passedTime[sharkPoint.row][sharkPoint.col] = 0;

		Queue<Point> q = new ArrayDeque<>();
		q.add(sharkPoint);
		int closestDistance = Integer.MAX_VALUE;
		List<Point> closestFishes = new ArrayList<>();
		while(!q.isEmpty()) {

			Point here = q.poll();

			if(closestDistance < passedTime[here.row][here.col]) break;

			if (isFish(here, sea) && isEdible(here, sea)) {
				if(closestDistance == Integer.MAX_VALUE) closestDistance = passedTime[here.row][here.col];
				if(closestDistance == passedTime[here.row][here.col]) closestFishes.add(here);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = here.row + dr[i];
				int nextCol = here.col + dc[i];
				if (isRange(nextRow, nextCol, sea) && !discovered[nextRow][nextCol]) {
					if (sea[nextRow][nextCol] <= size.getSizeLevel()) {
						discovered[nextRow][nextCol] = true;
						passedTime[nextRow][nextCol] = passedTime[here.row][here.col]+1;

						q.add(Point.create(nextRow, nextCol));
					}
				}
			}
		} //while
		
		//같은 거리의 물고기 정렬
		if(closestFishes.size() == 0) return -1;

		Comparator<Point> comparator = (a,b) -> {
			if(a.row == b.row) return Integer.compare(a.col,b.col);
			return Integer.compare(a.row,b.row);
		};
		closestFishes.sort(comparator);
		Point closestFish = closestFishes.get(0);
		eatFish(closestFish, sea);
		return passedTime[closestFishes.get(0).row][closestFishes.get(0).col];
	}

	public void eatFish(Point fishPosition, int[][] sea){
		sea[fishPosition.row][fishPosition.col] = 9;
		sea[sharkPoint.row][sharkPoint.col] = 0;
		move(fishPosition);
		size.expUp();
	}

	private void printSea(int[][] sea) {
		for (int i = 0; i < sea.length; i++) {
			System.out.println(Arrays.toString(sea[i]));
		}
		System.out.println();
	}


	private boolean isFish(Point point, int[][] sea){
		if(sea[point.row][point.col] > 0 && sea[point.row][point.col] < 9) return true;
		return false;
	}

	private boolean isEdible(Point fish, int[][] sea) {
		if(sea[fish.row][fish.col] != 0 && sea[fish.row][fish.col] < size.getSizeLevel()) return true;
		return false;
	}

	private boolean isRange(int row, int col, int[][] sea) {
		int n = sea.length; int m = sea[0].length;
		if(row < 0 || row >= n || col < 0 || col >= m) return false;
		return true;
	}

	private void move(Point nextPosition) {
		this.sharkPoint = nextPosition;
	}
}
class SharkSize {
	private int sizeLevel;
	private int exp;
	public SharkSize() {
		this.sizeLevel = 2;
		this.exp = 0;
	}

	public void expUp() {
		exp++;
		if(exp == sizeLevel) {
			sizeLevel++; exp = 0;
		}
	}
	public int getSizeLevel(){ return sizeLevel;}
}
class Point {
	int row, col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public static Point create(int row, int col) {
		return new Point(row, col);
	}

	@Override
	public String toString() {
		return "Point{" +
				"row=" + row +
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
