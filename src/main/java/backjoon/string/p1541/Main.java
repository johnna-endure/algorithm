package backjoon.string.p1541;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
백준 1541번 - 잃어버린 괄호
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader("testcase.txt");
		String input = reader.readLine();

		List<String> terms = split(input);
		int min = solve(terms);
		System.out.println(min);
	}

	private static List<String> split(String input) {
		Pattern pattern = Pattern.compile("[0-9]+|[\\-\\+]");
		Matcher matcher = pattern.matcher(input);
		List<String> terms = new ArrayList<>();
		while(matcher.find()) {
			terms.add(matcher.group());
		}
		return terms;
	}

	private static int solve(List<String> terms) {
		int totalSum = Integer.parseInt(terms.get(0));
		boolean minusFlag = false;
		for (int i = 1; i < terms.size(); i++) {
			String term = terms.get(i);
			
			//연산자인 경우
			if(isOperator(term) ) {
				if(term.equals("-")) minusFlag = true;
				continue;
			}
			//숫자인 경우
			int termVal = Integer.parseInt(term);
			if(minusFlag) {
				totalSum -= termVal;
			}else {
				totalSum += termVal;
			}
			
		}
		return totalSum;
	}

	public static boolean isOperator(String term) {
		if(term.equals("+") || term.equals("-")) return true;
		return false;
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

