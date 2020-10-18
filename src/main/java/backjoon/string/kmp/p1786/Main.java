package backjoon.string.kmp.p1786;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
KMP 알고리즘
문제 이름 : 찾기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InputReader inputReader = new InputReader("testcase.txt");
//		InputReader inputReader = new InputReader();
		String text = inputReader.readLine();
		String pattern = inputReader.readLine();

		KMPTextReader reader = new KMPTextReader(text, pattern);
		List<Integer> ret = reader.search(text, pattern);

		System.out.println(ret.size());
		if(ret.size() == 0) return;
		StringBuilder sb = new StringBuilder();
		ret.stream().forEach(i -> sb.append((i+1)+"\n"));
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}

class KMPTextReader {
	private String text;
	private String pattern;
	private int[] pi;

	public KMPTextReader(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
	}
	//text의 부분 문자열로 pattern이 출현하는 시작 위치들을 모두 반환한다.
	public List<Integer> search(String text, String pattern) {
		int textLength = text.length(), patternLength = pattern.length();
		List<Integer> ret = new ArrayList<>();

		pi = getPartialMatch(pattern);

		int begin = 0, matched = 0;
		while(begin + patternLength <= textLength) {
			//만약 짚더미의 해당 글자가 바늘의 해당 글자와 같다면
			if(matched < patternLength && text.charAt(begin+matched) == pattern.charAt(matched)) {
				matched++;
				//결과적으로 m글자가 모두 일치했다면 답에 추가한다.
				if(matched == patternLength) ret.add(begin);
			}
			else {
				//예외 : matched가 0인 경우에는 다음 칸에서부터 계속
				if(matched == 0) begin++;
				else {
					begin += matched - pi[matched-1];
					//begin을 옮겼다고 처음부터 다시 비교할 필요가 없다.
					//옮긴 후에도 pi[matched-1]만큼은 항상 일치하기 때문이다.
					matched = pi[matched-1];
				}
			}
		}
		return ret;
	}

	public int[] getPartialMatch(String pattern) {
		pi = new int[pattern.length()];

		int begin = 1, matched = 0;

		//비교할 문자가 N의 끝에 도달할 때까지 찾으면서 부분 일치를 모두 기록한다.
		while(begin + matched < pattern.length()) {
			if(pattern.charAt(begin+matched) == pattern.charAt(matched)) {
				matched++;
				pi[begin+matched-1] = matched;
			} else {
				if(matched == 0) begin++;
				else {
					begin += matched - pi[matched-1];
					matched = pi[matched-1];
				}
			}
		}
		return pi;
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
