package backjoon.graph.p1014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.min;

/*
백준 1014 - 컨닝
https://www.acmicpc.net/problem/1014
 */
public class Main {
    static int T,M,N;
    static int[][] seats, dp;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < T; testcase++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //세로 길이
			M = Integer.parseInt(st.nextToken()); //가로 길이

			seats = new int[N][M];
			for (int rowNum = 0; rowNum < N; rowNum++) {
				dp = new int[N][1<<M];
				String rowSeats = br.readLine();
				for (int column = 0; column < rowSeats.length(); column++) {
					seats[rowNum][column] = rowSeats.charAt(column) == '.' ? 1 : 0;
				}
			}
		}
    }
	public int solve() {
		List<Integer> arrangements = new ArrayList<>();



		return 0;
	}


	private static void addArrangements(int index, int arrangement, int prev_arrangement, int rowNum, List<Integer> ret) {
		if(index >= M) {
			ret.add(arrangement);
			return;
		}

    	if(isValid(rowNum, index, prev_arrangement, seats)) {
			int next_arrangement = arrangement | 1 << (M-index-1); //해당 자리가 유효할 경우 arrangement 에 비트 추가
			addArrangements(index+2, next_arrangement, prev_arrangement, rowNum, ret);
		}

		if(index < M-1 && isValid(rowNum, index+1, prev_arrangement, seats)) {
			int next_arrangement = arrangement | 1 << (M-index-2); //해당 자리가 유효할 경우 arrangement 에 비트 추가
			addArrangements(index+3, next_arrangement, prev_arrangement, rowNum, ret);
		}

		addArrangements(index+2, arrangement, prev_arrangement, rowNum, ret);
    }

    private static boolean isValid(int index,int rowNum, int prev_arrangement, int[][] seats) {
        if(seats[rowNum][index] == 0) return false; //자리가 부서진 경우
    	if(index == 0) {
		    if((prev_arrangement & 1 << (M-index-2)) != 0) return true;
	    }
    	if(index > 0 && index < M-1){
		    if((prev_arrangement & 1 << (M-index)) != 0
				    && (prev_arrangement & 1 << (M-index-2)) != 0) return true;
	    }
    	if(index == M-1){
		    if((prev_arrangement & 1 << (M-index)) != 0) return true;
	    }
    	return false;
    }
}
