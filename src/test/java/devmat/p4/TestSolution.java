package devmat.p4;

import devmatching2020.p4.Solution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class TestSolution {

	@Test
	public void test() {

		String[] vote = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
		Solution solution = new Solution();
		System.out.println(solution.solution(vote, 2));;

	}
}
