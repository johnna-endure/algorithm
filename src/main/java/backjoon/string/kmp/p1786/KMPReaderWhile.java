package backjoon.string.kmp.p1786;

import java.util.ArrayList;
import java.util.List;

/*
pi : 문자열에서 집두사 , 접미사가 일치하는 최대 길이. 문자열 전체 제외.
 */
public class KMPReaderWhile {

	private String text;
	private String pattern;
	private int[] pi;

	public KMPReaderWhile(String text, String pattern) {
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