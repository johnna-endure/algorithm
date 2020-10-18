package backjoon.string.p11365;

import java.io.*;
import java.util.Arrays;


/*
!밀비 급일
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		StringBuilder sb = new StringBuilder();
		while(reader.ready()) {
			String line = reader.readLine();
			if(line.equals("END")) break;
			sb.append(reverse(line)+"\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());

	}

	private static String reverse(String line) {
		char[] chars = line.toCharArray();
		int head = 0; int tail = line.length()-1;
		while(head < tail) {
			swap(head, tail, chars);
			head++; tail--;
		}
		return new String(chars);
	}

	private static void swap(int head, int tail, char[] chars) {
		char temp = chars[head];
		chars[head] = chars[tail];
		chars[tail] = temp;
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