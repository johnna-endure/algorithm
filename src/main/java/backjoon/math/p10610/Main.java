package backjoon.math.p10610;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		String input = reader.readLine();
		List<Integer> numbers = new ArrayList<>();

		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			int digit = input.charAt(i) - 48;
			numbers.add(digit);
			sum += digit;
		}

		numbers.sort(Comparator.reverseOrder());
		if(numbers.get(numbers.size()-1) != 0) {
			System.out.println(-1); return;
		}

		if(sum % 3 == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numbers.size(); i++) {
				sb.append(numbers.get(i));
			}
			System.out.println(sb.toString());
		}else System.out.println(-1);

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