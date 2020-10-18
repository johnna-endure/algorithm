package devmat.p2;

import devmatching2020.p2.Solution;
import org.junit.Test;

import java.time.LocalTime;

public class TestSolution {
	Solution sol = new Solution();

	@Test
	public void timeTest() {
		String timestr = "01:02:03";
		LocalTime time = LocalTime.parse(timestr);
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());

		String a = "AM 123";
		System.out.println(a.substring(2).trim());
	}

	@Test
	public void test() {
		LocalTime time = LocalTime.parse("23:59:59");
		System.out.println(time.plusSeconds(150000));
	}

	@Test
	public void testSol() {
		System.out.println(sol.solution("PM 11:59:59", 3600));;
	}
}
