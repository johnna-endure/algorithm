package backjoon.implementation.p3190;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 3190번 - 뱀
https://www.acmicpc.net/problem/3190
 */
public class Main {
	static int n,k,l;
	static int[][] apple;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		apple = new int[n][n];

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			apple[y][x] = 1;
		}

		l = Integer.parseInt(br.readLine());
		Queue<Command> commandQueue = new ArrayDeque<>();
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			commandQueue.add(new Command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}

		visited = new boolean[n][n];
		int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; //동 남 서 북
		int time = 0;
		int directionIdx = 0;
		ArrayDeque<Location> snake = new ArrayDeque<>();
		snake.add(new Location(0,0));
		visited[0][0] = true;

		while(true) {
			time++;
			Location before = snake.peekLast();
			Location current = new Location(before.y + directions[directionIdx][0], before.x+directions[directionIdx][1]);
			//범위를 벗어나거나 몸에 부딪히는 경우
			if(!current.isRange(n) || visited[current.y][current.x]) {
				System.out.println(time);
				break;
			}

			visited[current.y][current.x] = true;
			snake.add(current);

			//사과가 있는 자리인 경우
			if(apple[current.y][current.x] == 1) apple[current.y][current.x] = 0; // 사과 먹음
			//사과가 없는 자리인 경우
			else {
				Location tail = snake.pollFirst();
				visited[tail.y][tail.x] = false;
			}

			//방향 전환
			if(!commandQueue.isEmpty() && commandQueue.peek().time == time) {
				if (commandQueue.peek().turn == 'L') {
					directionIdx = (directionIdx + 3) % 4;
				}else
					directionIdx = (directionIdx + 1) % 4;
				commandQueue.poll();
			}
		}
	}
}
class Location {
	int x,y;

	public Location(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public boolean isRange(int n) {
		if(x < 0 || x >= n || y < 0 || y >= n) return false;
		return true;
	}

}

class Command{
	int time;
	char turn;

	public Command(int time, char turn) {
		this.time = time;
		this.turn = turn;
	}
}
