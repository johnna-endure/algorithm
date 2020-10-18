package backjoon.string.p1652;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
누울 자리를 찾아라
https://www.acmicpc.net/problem/1652
 */
public class Main {
	static int n;
	static String[] room;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		room = new String[n];
		for (int i = 0; i < n; i++) {
			room[i] = reader.readLine();
		}
		//가로 방향 체크
		int rowSeats = 0;
		for (int row = 0; row < n; row++) {
			rowSeats += howManySeats(room[row]);
		}

		int colSeats = 0;
		for (int col = 0; col < n; col++) {
			String line = scanCol(col);
			colSeats += howManySeats(line);
		}

		System.out.println(rowSeats + " " + colSeats);
		
	}

	private static String scanCol(int col) {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < n; row++) {
			sb.append(room[row].charAt(col));
		}
		return sb.toString();
	}

	public static int howManySeats(String line) {
		Pattern pattern = Pattern.compile("(\\.{2,})");
		Matcher matcher = pattern.matcher(line);

		int cnt = 0;
		while(matcher.find()) {
			cnt++;
		}
		return cnt;
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