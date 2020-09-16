package backjoon.implementation.p10797;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int total = 0;
		while(st.hasMoreTokens()) {
			int car = Integer.parseInt(st.nextToken());
			if(car == n) {
				total++;
			}
		}

		System.out.println(total);
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
