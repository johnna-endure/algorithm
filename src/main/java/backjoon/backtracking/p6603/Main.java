package backjoon.backtracking.p6603;

import java.io.*;
import java.util.*;

/*
백준 6603번 - 로또
https://www.acmicpc.net/problem/6603
*/
public class Main {
	static HashSet<String> set;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");

		while (true) {
			String line = reader.readLine();
			if (line.equals("0")) break;

			StringTokenizer st = new StringTokenizer(line);
			int k = Integer.parseInt(st.nextToken());
			int[] numArr = new int[k];
			for (int i = 0; i < k; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}
			set = new HashSet<>();
			findNumberSet(0,0,new ArrayList<>(), numArr);

			StringBuilder sb = new StringBuilder();
			String[] subsets = new String[set.size()];
			set.toArray(subsets);

			Comparator<String> comparator = (s1, s2) -> {
				StringTokenizer st1 = new StringTokenizer(s1);
				StringTokenizer st2 = new StringTokenizer(s2);

				while(st1.hasMoreTokens() && st2.hasMoreTokens()) {
					int n1 = Integer.parseInt(st1.nextToken());
					int n2 = Integer.parseInt(st2.nextToken());

					if(n1 > n2) return 1;
					if(n1 < n2) return -1;
				}
				return 0;
			};

			Arrays.sort(subsets, comparator);
			Arrays.stream(subsets).forEach(e -> sb.append(e+"\n"));
			sb.deleteCharAt(sb.length()-1);

			System.out.println(sb.toString());
			System.out.println();
		}
	}

	private static void findNumberSet(int here, int cnt, List<Integer> nums , int[] numArr) {
		if(cnt == 6) {
			String subset = nums.stream().map(n -> String.valueOf(n))
					.reduce((n1, n2) -> n1 + " " + n2).get();
			set.add(subset);
		}
		if(here == numArr.length) return;

		//포함하지 않는 경우
		findNumberSet(here+1, cnt, nums, numArr);

		//포함하는 경우
		nums.add(numArr[here]);
		findNumberSet(here+1, cnt+1, nums, numArr);
		nums.remove(nums.size()-1);
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
