package backjoon.graph.p14502;

import java.io.*;
import java.util.*;

public class Main {
	static int n,m, wallCnt=0;
	static int[][] map;
	static boolean[][] discovered;
	static List<Point> virusList;
	public static void main(String[ ] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		virusList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virusList.add(new Point(i,j));
				if(map[i][j] == 1) wallCnt++;
			}
		}

//		System.out.println(virusList);

		int ret = solve();
		System.out.println(ret);
	}

	private static int solve() {
		int max = 0;
		for (int i = 0; i < n*m; i++) {
			for (int j = i+1; j < n*m; j++) {
				for (int k = j+1; k < n*m; k++) {
					Point wall1 = new Point(i/m, i%m);
					Point wall2 = new Point(j/m, j%m);
					Point wall3 = new Point(k/m, k%m);

					if(isEmptySpace(wall1, wall2, wall3)) {
						discovered = new boolean[n][m];
						max = Math.max(max, infect(wall1, wall2, wall3));
					}
				}
			}
		}
		return max;
	}

	private static boolean isEmptySpace(Point wall1, Point wall2, Point wall3) {
		if(map[wall1.row][wall1.col] == 0 && map[wall2.row][wall2.col] == 0
				&& map[wall3.row][wall3.col] == 0) return true;
		return false;
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	private static int infect(Point wall1, Point wall2, Point wall3) {
		//벽 생성
		map[wall1.row][wall1.col] = 1;
		map[wall2.row][wall2.col] = 1;
		map[wall3.row][wall3.col] = 1;
		
		//큐 초기화 - 바이러스; 블록 큐에 저장
		Queue<Point> queue = new ArrayDeque<>();
		virusList.stream().forEach(p -> {
			discovered[p.row][p.col] = true;
			queue.add(p);
		});
		int totalInfected = virusList.size();

		while(!queue.isEmpty()) {
			Point here = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextR = here.row + dr[i];
				int nextC = here.col + dc[i];

				if(isRange(nextR, nextC) && map[nextR][nextC] == 0
						&&!discovered[nextR][nextC]) {
					totalInfected++;
					discovered[nextR][nextC] = true;
					queue.add(new Point(nextR, nextC));
				}
			}
		}

		//벽 제거 - 원상복구
		map[wall1.row][wall1.col] = 0;
		map[wall2.row][wall2.col] = 0;
		map[wall3.row][wall3.col] = 0;

		return n*m - totalInfected - (wallCnt+3);
	}

	private static boolean isRange(int nextR, int nextC) {
		if(nextR >= n || nextR < 0 || nextC >= m || nextC < 0) return false;
		return true;
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

