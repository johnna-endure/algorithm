package backjoon.bitmask.p14889;

import java.io.*;
import java.util.*;


/*
백준 14889번 - 스타트와 링크
https://www.acmicpc.net/problem/14889
 */
public class Main {
	static int n, INF = 987654321;
	static int[][] ability;
	static List<Integer> statusSet = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();
		n = reader.readInt();
		ability = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selectStartMember(1,0,0);

		System.out.println(solve());
		
	}

	private static int solve() {
		int diff = INF;
		for (int selected : statusSet) {
			//start 팀 능력 계산
			int startAbility = 0;
			List<Integer> startTeam = convertToList(selected);
//			System.out.println("startTeam :" + startTeam);
			for (int i = 0; i < startTeam.size(); i++) {
				int memberA = startTeam.get(i);
				for (int j = i+1; j < startTeam.size(); j++) {
					int memberB = startTeam.get(j);
					startAbility += ability[memberA][memberB];
					startAbility += ability[memberB][memberA];
				}
			}

			//link 팀 능력 계산
			int linkAbility = 0;
			int fullBit = (1 << n+1)-1;
			int selectedLink = fullBit ^ selected;
			List<Integer> linkTeam = convertToList(selectedLink);
//			System.out.println("linkTeam :" + linkTeam);
//			System.out.println();
			for (int i = 0; i < linkTeam.size(); i++) {
				int memberA = linkTeam.get(i);
				for (int j = i+1; j < linkTeam.size(); j++) {
					int memberB = linkTeam.get(j);

					linkAbility += ability[memberA][memberB];
					linkAbility += ability[memberB][memberA];
				}
			}

			diff = Math.min(Math.abs(startAbility - linkAbility), diff);
		}
		return diff;
	}
	/*
		비트를 리스트로 변환
	 */
	private static List<Integer> convertToList(int bit) {
		List<Integer> team = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if((bit & (1 << i)) != 0) team.add(i);
		}
		return team;
	}
	
	private static void selectStartMember(int index, int count, int selected) {
		if(count == n/2) {
			statusSet.add(selected); return;
		}
		if(index > n) return;

		//선택한 경우
		selectStartMember(index+1, count+1, selected | 1 << index);
		//선택하지 않은 경우
		selectStartMember(index+1, count, selected);
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

