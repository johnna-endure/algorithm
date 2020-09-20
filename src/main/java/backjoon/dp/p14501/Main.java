package backjoon.dp.p14501;

import java.io.*;
import java.util.StringTokenizer;

/*
백준 14501번 - 퇴사
https://www.acmicpc.net/problem/14501
 */
public class Main {
	static int n;
	static Schedule[] schedules;
	static int[] dp;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		schedules = new Schedule[n+1];
		dp = new int[n+1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int time = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			schedules[i] = new Schedule(time, pay);
		}
		System.out.println(solve());
//		System.out.println(solve(1,0)); //재귀 버전
	}
	//완전탐색 재귀 버전
//	private static int solve(int i, int acc) {
//		if(i > n) return 0;
//		if(i == n) return acc;
//
// 		int ret = Math.max(solve(i + schedules[i].time, acc+schedules[i].pay) , solve(i+1, acc));;
//
//		return ret;
//	}

	private static int solve() {
		for (int i = 0; i < n; i++) {
			Schedule schedule = schedules[i];
			//선택하는 경우
			int nextIdx = i + schedule.time;
			if(nextIdx <= n) dp[nextIdx] = Math.max(dp[i] + schedule.pay, dp[nextIdx]);

			//선택하지 않는 경우
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		return dp[n];
	}
}
class Schedule{
	int time, pay;
	public Schedule(int time, int pay) {
		this.time = time;
		this.pay = pay;
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
