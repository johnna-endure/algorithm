package backjoon.bruteforce.p1208;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
부분수열의 합2
https://www.acmicpc.net/problem/1208
 */
public class Main {
	static int n,s;
	static int[] nums;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader();
		InputReader reader = new InputReader("testcase.txt");

		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> left = new ArrayList<>();
		getSumList(0, n/2,0,left);

		List<Integer> right = new ArrayList<>();
		getSumList(n/2, n,0,right);

		left.sort(Comparator.reverseOrder());
		right.sort(Comparator.naturalOrder());

		long cnt = countIfEqualsSumS(left, right);
		if(s == 0) cnt--;
		System.out.println(cnt);
	}

	private static long countIfEqualsSumS(List<Integer> left, List<Integer> right) {
		long cnt = 0;

		int li = 0, ri = 0;
		while(li < left.size() && ri < right.size()) {
//			System.out.format("li : %d, ri : %d\n", li, ri);
			int leftSum = left.get(li);
			int rightSum = right.get(ri);

			int sum = leftSum + rightSum;
			if(sum > s) {
				li++;
				continue;
			}
			if(sum < s) {
				ri++;
				continue;
			}

			if(sum == s) {
				long leftCnt = 0l, rightCnt = 0l;
				while(ri < right.size() && leftSum + right.get(ri) == s) {
					ri++;
					rightCnt++;
				}
				while(li < left.size() && rightSum + left.get(li) == s) {
					li++;
					leftCnt++;
				}

				cnt += leftCnt * rightCnt;
			}
		}
		return cnt;
	}

	public static void getSumList(int i, int end, int acc, List<Integer> sumList) {
		if(i == end) {
			sumList.add(acc);
			return;
		}

		//포함하지 않는 경우
		getSumList(i+1,end, acc, sumList);
		//포함하는 경우
		getSumList(i+1, end, acc+nums[i], sumList);
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

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
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
