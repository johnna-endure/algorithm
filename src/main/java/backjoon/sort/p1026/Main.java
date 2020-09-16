package backjoon.sort.p1026;

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Integer> a,b;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
		n = reader.readInt();
		a = new ArrayList<>(n); b = new ArrayList<>(n);;

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		Comparator<Integer> descendingOrder = Comparator.reverseOrder();
		a.sort(descendingOrder);
		Collections.sort(b);

		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a.get(i) * b.get(i);
		}
		System.out.println(sum);
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

