package backjoon.implementation.p2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		String[] croAlphabetArray = {
				"c=","c-","dz=","d-",
				"lj","nj","s=","z="
		};
		int cnt = getCnt(s,0, croAlphabetArray);
		System.out.println(cnt);
	}

	public static int getCnt(String s, int cnt, String[] cro_alp) {
		if(s.length() == 0) return cnt;
		int matched = Arrays.stream(cro_alp)
				.filter(alp -> alp.length() <= s.length())
				.filter(alp -> s.startsWith(alp))
				.map(alp -> alp.length())
				.findFirst().orElse(1);

		return getCnt(s.substring(matched), cnt+1, cro_alp);
	}

}
