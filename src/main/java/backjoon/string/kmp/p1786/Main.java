package backjoon.string.kmp.p1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
KMP 알고리즘
문제 이름 : 찾기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		String pattern = br.readLine();

		KMPReader reader = new KMPReader(text, pattern);
		List<Integer> ret = reader.search();
		System.out.println(ret.size());
		ret.stream().forEach(i -> System.out.println(i+1));
	}

	public static class KMPReader {

		private String text;
		private String pattern;
		private int[] piArray;

		public KMPReader(String text, String pattern) {
			this.text = text;
			this.pattern = pattern;
			this.piArray = new int[pattern.length()];
		}

		public void setPiArray(int begin, int comparing, int matched) {
			int current = begin + comparing;
			if(current >= pattern.length() || begin >= pattern.length()) return;

			while(current < pattern.length()) {

				if(pattern.charAt(current) == pattern.charAt(comparing)) {
					matched++; comparing++;
					piArray[current] = Math.max(piArray[current], matched);
					current = begin + comparing;
					continue;
				}

				if(current == begin) {
					setPiArray(begin+1, 0, 0);
					return;
				}
				int next_begin = current-piArray[comparing-1];
				int delta = next_begin - begin;
				int next_comparing = comparing - delta;
				setPiArray(next_begin, next_comparing, piArray[comparing-1]);
				return;
			}
		}

		public List<Integer> search(){
			List<Integer> ret = new ArrayList<>();
			setPiArray(1, 0, 0);
			searchLoop(0,0,0,ret);
			return ret;
		}

		private void searchLoop(int begin, int comparing, int matched, List<Integer> ret) {
			//종결 조건
			if(begin > text.length()-pattern.length() || comparing > pattern.length()) return;
			int current = begin + comparing;
			while(comparing < pattern.length()) {
				//일치하는 경우
				if(text.charAt(current) == pattern.charAt(comparing)) {
					matched++;

					if(matched == pattern.length()) {
						ret.add(begin);

						if(comparing == 0) {
							searchLoop(current+1,0,0,ret); return;
						}

						int next_begin = current-piArray[comparing];
						int delta = next_begin - begin;
						searchLoop(current-piArray[comparing-1], comparing - delta, piArray[comparing], ret); return;
					}
					comparing++;
					current = begin + comparing;
					continue;
				}
				//일치하지 않는 경우
				if(begin == current) {
					searchLoop(begin+1,0,0,ret); return;
				}
				int next_begin = current - piArray[comparing-1];
				int delta = next_begin - begin;
				searchLoop(next_begin, comparing - delta, piArray[comparing-1], ret); return;
			}

		}

		public int[] getPiArray() {
			return this.piArray;
		}
	}

}
