package backjoon.sort.p11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] times;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();

		n = reader.readInt();
		times = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(times);
//		System.out.println(Arrays.toString(times));

		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				ret += times[j];
			}
		}
		System.out.println(ret);
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

