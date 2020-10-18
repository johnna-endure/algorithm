package backjoon.implementation.p10886;

import java.io.*;

/*
0 = not cute / 1 = cute
https://www.acmicpc.net/problem/10886
 */
public class Main {
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		int n = reader.readInt();

		int cute = 0;
		int notCute = 0;

		for (int i = 0; i < n; i++) {
			if(reader.readInt() == 1){
				cute++;
			}else {
				notCute++;
			}
		}
		if(cute > notCute) System.out.println("Junhee is cute!");
		else System.out.println("Junhee is not cute!");
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
