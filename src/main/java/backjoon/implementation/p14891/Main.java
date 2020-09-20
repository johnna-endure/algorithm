package backjoon.implementation.p14891;

import java.io.*;
import java.util.StringTokenizer;

/*
백준 14891번 - 톱니바퀴
https://www.acmicpc.net/problem/14891
 */
public class Main {
	static int k;
	static Gear[] gears = new Gear[4];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		for (int i = 0; i < 4; i++) {
			int[] status = reader.readLine().chars()
					.map(c -> c-48)
					.toArray();
			gears[i] = new Gear(i,status);
		}
		initGears();

		k = reader.readInt();
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int gearNum = Integer.parseInt(st.nextToken());
			int rotateDirection = Integer.parseInt(st.nextToken());
			visited = new boolean[4];
			gears[gearNum-1].rotate(rotateDirection, visited);
		}

		int sum = getSum();
		System.out.println(sum);
	}
	/*
	12시가 s일 경우 [1,2,4,8]
	 */
	static int[] score = {1,2,4,8};
	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			int[] gearStatus = gears[i].status;
			int topIdx = gears[i].topToothIdx;
			if(gearStatus[topIdx] == 1) sum += score[i];
		}
		return sum;
	}


	private static void initGears() {
		//0번 기어
		gears[0].leftGear = null;
		gears[0].rightGear = gears[1];

		//1번 기어
		gears[1].leftGear = gears[0];
		gears[1].rightGear = gears[2];

		//2번 기어
		gears[2].leftGear = gears[1];
		gears[2].rightGear = gears[3];

		//3번 기어
		gears[3].leftGear = gears[2];
		gears[3].rightGear = null;
	}
}

class Gear {
	int number;
	int[] status; // N : 0, S : 1
	Gear leftGear, rightGear;
	int topToothIdx, leftTooth, rightTooth;

	public Gear(int number, int[] status) {
		this.number = number;
		this.status = status;

		topToothIdx = 0;
		leftTooth = status[(topToothIdx+6)%8];
		rightTooth = status[(topToothIdx+2)%8];
	}

	/*
	1 : 시계 방향,
	-1 : 반시계 방향
	0 : 그대로
	 */
	public void rotate(int rotateDirection, boolean[] visited) {
		if(visited[number]) return;

		visited[number] = true;

		if(rotateDirection == 0) return;
		if(leftGear != null) {
			if(leftTooth != leftGear.rightTooth) leftGear.rotate(-rotateDirection, visited);
			else leftGear.rotate(0, visited);
		}
		if(rightGear != null) {
			if(rightTooth != rightGear.leftTooth) {
				rightGear.rotate(-rotateDirection, visited);
			}
			else rightGear.rotate(0, visited);
		}


		// 바퀴를 돌린다
		if(rotateDirection == 1) {
			topToothIdx = (topToothIdx+7)%8;
		}

		if(rotateDirection == -1 ){
			topToothIdx = (topToothIdx+1)%8;
		}
		leftTooth = status[(topToothIdx+6)%8];
		rightTooth = status[(topToothIdx+2)%8];
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
