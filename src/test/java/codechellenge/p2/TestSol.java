package codechellenge.p2;

import codechallenge.p2.Solution;
import org.junit.Test;

import java.util.Arrays;

public class TestSol {
	Solution solution = new Solution();
	int[][] arr= {
			{1,1,0,0},
			{1,0,0,0},
			{1,0,0,1},
			{1,1,1,1}
	};
	@Test
	public void testSol() {
		System.out.println(	Arrays.toString(solution.solution(arr)));
	}
}
