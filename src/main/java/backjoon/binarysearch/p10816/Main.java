package backjoon.binarysearch.p10816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 10816번 - 숫자 카드 2
 */
public class Main {
	static int N,M;
	static int[] cards;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cards = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);
//		System.out.println(Arrays.toString(cards));
		M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			int targetNum = Integer.parseInt(st.nextToken());
			int upper = upperBound(targetNum);
			int lower = lowerBound(targetNum);
//			System.out.format("targetNum : %d, upper : %d, lower : %d\n",targetNum, upper, lower);
			if(upper != lower) {
				sb.append(upper - lower + 1);
			}
			if(upper == lower) {
				if(upper == -1) sb.append(0);
				else sb.append(1);
			}
			sb.append(" ");
		}

		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int lowerBound(int targetNum) {
		int start = 0; int end = cards.length-1;

		while(true) {
			int mid = (start+end)/2;
			int cardNum = cards[mid];

			if(start == end) {
				if(cardNum == targetNum) return start;
				return -1;
			}

			if(cardNum >= targetNum) {
				end = mid; continue;
			}

			if(cardNum < targetNum) {
				start = mid+1; continue;
			}

		}
	}

	private static int upperBound(int targetNum) {
		int start = 0; int end = cards.length-1;

		while(true) {
//			System.out.format("start : %d, end : %d\n", start, end);
			int mid = (start+end+1)/2;
			int cardNum = cards[mid];

			if(start == end) {
				if(cardNum == targetNum) return start;
				return -1;
			}

			if(cardNum > targetNum) {
				end = mid-1; continue;
			}
			if(cardNum <= targetNum) {
				start = mid; continue;
			}
		}
	}

}
