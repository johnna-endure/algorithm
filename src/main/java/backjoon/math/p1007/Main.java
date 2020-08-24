package backjoon.math.p1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
백준 1007 벡터 매칭
https://www.acmicpc.net/problem/1007
 */
public class Main {

    static int T,N;
    static double INF = 9876543210d;
    static boolean[] isHead;
    static List<Point> points;
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
	T = Integer.parseInt(br.readLine());

	for (int testCase = 0; testCase < T; testCase++) {
	    N = Integer.parseInt(br.readLine());
	    isHead = new boolean[N];
	    points = new ArrayList<>();
	    for (int i = 0; i < N; i++) {
	        String[] pointInput = br.readLine().split(" ");
	        int x = Integer.parseInt(pointInput[0]);
	        int y = Integer.parseInt(pointInput[1]);
		points.add(new Point(x,y));
	    }

	    double ans = solve(0,1);
	    System.out.println(ans);
	}


    }

    private static double solve(int index, int count) {
	isHead[index] = true;

	if(count == N/2) {
	    double ret = getVectorSize();
	    isHead[index] = false;
            return ret;
	}

        double ret = INF;
	for (int i = index+1; i < N; i++) {
	    if(!isHead[i]) {
	        ret = Math.min(solve(i, count+1), ret);
	    	isHead[i] = false;
	    }
	}

	return ret;
    }

    private static double getVectorSize() {
        double totalX = 0;
	double totalY = 0;

	for (int i = 0; i < N; i++) {
	    if(isHead[i]) {
	        totalX += points.get(i).x;
	        totalY += points.get(i).y;
	    }else {
		totalX -= points.get(i).x;
		totalY -= points.get(i).y;
	    }
	}
        return Math.sqrt(totalX*totalX + totalY*totalY);
    }
}
class Point {
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}