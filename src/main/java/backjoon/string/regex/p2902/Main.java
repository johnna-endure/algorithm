package backjoon.string.regex.p2902;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
백준 2902번 KMP는 왜 KMP일까?
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		String input = reader.readLine();

		System.out.println(solve(input));
	}

	private static String solve(String input) {
		Pattern pattern = Pattern.compile("-?([A-Z])");
		Matcher matcher = pattern.matcher(input);

		StringBuilder sb = new StringBuilder();
		while(matcher.find()) {
			sb.append(matcher.group(1));
		}
		return sb.toString();
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
}

