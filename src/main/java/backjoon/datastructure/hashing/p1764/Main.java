package backjoon.datastructure.hashing.p1764;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static int n,m;
	static List<String> dontHeard = new ArrayList<>();
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		HashSet<String> dontLook = new HashSet<>();
		for (int i = 0; i < n; i++) {
			dontLook.add(reader.readLine());
		}

		for (int i = 0; i < m; i++) {
			dontHeard.add(reader.readLine());
		}

		dontHeard.sort(Comparator.naturalOrder());
//		System.out.println(dontHeard);
		List<String> ret = dontHeard.stream()
				.filter(s -> dontLook.contains(s))
				.collect(Collectors.toList());
		System.out.println(ret.size());
		ret.forEach(s -> System.out.println(s));
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



