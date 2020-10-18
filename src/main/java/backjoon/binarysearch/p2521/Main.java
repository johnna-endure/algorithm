package backjoon.binarysearch.p2521;

import java.io.*;
import java.util.*;

/*
예산
https://www.acmicpc.net/problem/2512
*/
public class Main {
	static int n;
	static long m;
	static List<Integer> budgetRequests;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();
		n = reader.readInt();

		budgetRequests = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			budgetRequests.add(Integer.parseInt(st.nextToken()));
		}
		budgetRequests.sort(Comparator.naturalOrder());
		m = reader.readLong();
//		System.out.println(budgetRequests);

//		int max = getMaxBudget();
		int max = getMaxBudget2(0, budgetRequests.get(budgetRequests.size()-1));
		System.out.println(max);

	}
	//재귀 버전
	private static int getMaxBudget2(int low, int high) {
		//종결 조건
		int mid = (low + high)/2;
		if(high < low) {
			return mid;
		}

		long totalBudget = getTotalBudget(mid);
//		System.out.format("low : %d, high : %d, totalBudget : %d, mid : %d\n", low, high, totalBudget, mid);
		if(totalBudget > m) return getMaxBudget2(low, mid-1);
		else if(totalBudget < m) return getMaxBudget2(mid+1, high);
		else return mid;
	}

	//while문으로 이분 탐색
	private static int getMaxBudget() {
		int low = 0; int high = budgetRequests.get(budgetRequests.size()-1);
		int mid = (low + high)/2;
		while(low <= high) {
			long totalBudget = getTotalBudget(mid);

			if(totalBudget > m) high = mid-1;
			else if(totalBudget < m) low = mid+1;
			else return mid;

			mid = (low + high)/2;
//			System.out.format("low : %d, high : %d, totalBudget : %d, mid : %d\n", low, high, totalBudget, mid);
		}
		return mid;
	}



	private static long getTotalBudget(int budget) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int budgetRequest = budgetRequests.get(i);
			if(budgetRequest <= budget) {
				sum += budgetRequest; continue;
			}
			sum += budget * (n-i); break;
		}
		return sum;
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