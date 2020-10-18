package backjoon.graph.p1525;

import java.io.*;
import java.util.*;

/*
퍼즐
https://www.acmicpc.net/problem/1525
 */
public class Main {
	static long[][] puzzle = new long[3][3];
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 3; j++) {
				puzzle[i][j] = Long.parseLong(st.nextToken());
			}
		}
		long[][] destArr = {
				{1,2,3},
				{4,5,6},
				{7,8,0}
		};
		long destState = getStatus(destArr);
		int ret = bfs(destState);
		System.out.println(ret);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	private static int bfs(long destState) {
		Queue<Node> q = new ArrayDeque<>();
		HashSet<Long> visitedStatus = new HashSet<>();
		long firstState = getStatus(puzzle);
		if(firstState == destState) return 0;
		visitedStatus.add(firstState);
		q.add(new Node(firstState,0));

		while(!q.isEmpty()) {
			Node here = q.poll();
			//puzzle에 state를 그리고 빈칸의 위치를 반환
			Point currentZero = writeStateOnArray(here.state, puzzle);

			for (int i = 0; i < 4; i++) {
				Point nextZero = new Point(currentZero.row + dr[i],  currentZero.col + dc[i]);
				if(nextZero.isRange()) {
					//이동이 가능한 점이라면 swap
					swap(currentZero, nextZero, puzzle);
					long nextState = getStatus(puzzle);
					//다음 요소를 위해 변화 복구
					swap(nextZero, currentZero, puzzle);
					//도착지 상태와 동일한 경우
					if(nextState == destState) return here.dist + 1;
					//방문하지 않은 경우 hashSet에 저장
					if(!visitedStatus.contains(nextState)) {
						q.add(new Node(nextState, here.dist+1));
						visitedStatus.add(nextState);
					}
				}
			}//for
		}//while

		return -1;
	}

	private static void swap(Point a, Point b, long[][] puzzle) {
		long temp = puzzle[a.row][a.col];
		puzzle[a.row][a.col] = puzzle[b.row][b.col];
		puzzle[b.row][b.col] = temp;
	}

	//long형 정수에 저장된 state를 puzzle 배열에 복원하고 zero의 위치 반환
	private static Point writeStateOnArray(long state, long[][] puzzle) {
		int order = 0;
		long fourFullBit = (1 << 4) - 1;
		Point zero = null;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				long num = state & (fourFullBit << (4*order));
				puzzle[i][j] = (num >> (4*order));
				order++;
				if(puzzle[i][j] == 0) { zero = new Point(i,j); }
			}
		}

		return zero;
	}
	
	//puzzle 배열의 상태를 비트마스킹한 long형 정수 반환	
	private static Long getStatus(long[][] puzzle) {
		long s = 0l;
		int order = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				s |= puzzle[i][j] << (4*order);
				order++;
			}
		}
		return s;
	}
}
class Point {
	int row, col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public boolean isRange() {
		if(row < 0 || row >= 3 || col < 0 || col >= 3) return false;
		return true;
	}
}
class Node {
	long state;
	int dist;

	public Node(long state, int dist) {
		this.state = state;
		this.dist = dist;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Node node = (Node) o;

		return state == node.state;
	}

	@Override
	public int hashCode() {
		return (int) (state ^ (state >>> 32));
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