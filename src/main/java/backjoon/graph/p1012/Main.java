package backjoon.graph.p1012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 1012 유기농 배추
https://www.acmicpc.net/problem/1012
 */
public class Main {
    static int T,M,N,K;
    static int[][] area;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static List<Point> cabbages;
    static boolean[][] visitedCabbage;
    public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	T = Integer.parseInt(br.readLine());

	for (int i = 0; i < T; i++) {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken()); //가로 길이
	    N = Integer.parseInt(st.nextToken()); //세로 길이
	    area = new int[N][M];
	    visitedCabbage = new boolean[N][M];
	    K = Integer.parseInt(st.nextToken()); //배추 개수

	    cabbages = new ArrayList<>();
	    for (int j = 0; j < K; j++) {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
	        cabbages.add(new Point(x,y));
		area[y][x]=1;
	    }

	    int ret = 0;
	    for (int cabbageIndex = 0; cabbageIndex < cabbages.size(); cabbageIndex++) {
		Point cabbage = cabbages.get(cabbageIndex);
	        if(!visitedCabbage[cabbage.y][cabbage.x]) {
	            ret++;
	            solve(cabbage.y, cabbage.x);
		}
	    }
	    System.out.println(ret);
	}
    }

    private static void solve(int y, int x) {
        if(y < 0 || x < 0) return ;
        if(y >= N || x >= M) return ;
	if(area[y][x] == 0) return;

	visitedCabbage[y][x] = true;
	for (int i = 0; i < 4; i++) {
	    int nextY = y+dy[i]; int nextX = x+dx[i];
	    if(isRange(nextY,nextX)
		    && !visitedCabbage[nextY][nextX] && area[nextY][nextX] == 1)
	        solve(nextY, nextX);
	}
    }

    private static boolean isRange(int y, int x) {
        if(x < 0 | x >= M | y < 0 | y >= N) return false;
        return true;
    }
}
class Point{
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
