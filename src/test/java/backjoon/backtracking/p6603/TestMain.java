package backjoon.backtracking.p6603;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class TestMain {
	@Test
	public void sortTest(){
		String a = "1 2 3 4";
		String b = "1 2 11 12";
		List<String> l = Arrays.asList(a,b);

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

		l.sort(comparator);
		System.out.println(l);
	}
}
