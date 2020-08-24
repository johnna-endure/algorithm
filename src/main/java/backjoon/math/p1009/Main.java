package backjoon.math.p1009;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T,a,b;
    static int[][] d={{10},{1},{6,2,4,8},{1,3,9,7},{6,4},{5},{6},{1,7,9,3},{6,8,4,2},{1,9}};
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
    	T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < T; i++) {
	    String[] input = br.readLine().split(" ");
	    a = Integer.parseInt(input[0]);
	    b = Integer.parseInt(input[1]);

	    int ret = solve(a,b);
	    sb.append(ret+"\n");
	}
	sb.deleteCharAt(sb.length()-1);
	System.out.println(sb.toString());
    }

    private static int solve(int a, int b) {
        int mod = a%10;
        return d[mod][b % (d[mod].length)];
    }
}
