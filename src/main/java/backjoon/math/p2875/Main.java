package backjoon.math.p2875;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
대회 or 인턴
https://www.acmicpc.net/problem/2875
 */
public class Main {
	static int n,m,k;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int a = Math.round((2*m + k - n)/3f);
		if(a > k) a = k;
		if(a < 0) a = 0;

		int ret = makeTeam(n-k+a, m-a);
		System.out.println(ret);
	}

	private static int makeTeam(int woman, int man) {
		int teamCnt = 0;
		while(woman >= 2 && man >= 1) {
			woman -= 2;
			man--;
			teamCnt++;
		}
//		System.out.println(woman+ " "+man);
		return teamCnt;
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