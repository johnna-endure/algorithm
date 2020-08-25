package backjoon.string.regex.p1013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
백준 1013 - Contact
https://www.acmicpc.net/problem/1013
 */
public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());

	for (int testcase = 0; testcase < T; testcase++) {
	    String ret = solve(br.readLine());
	    System.out.println(ret);
	}
    }

    // (100+1+ | 01)+
    private static String solve(String input) {
	Pattern pattern = Pattern.compile("((100+1+)|(01))+");
	Matcher matcher = pattern.matcher(input);

 	return matcher.matches() ? "YES" : "NO";
    }
}
