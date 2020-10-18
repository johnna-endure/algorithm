package codechallenge.p1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int solution(int n) {
		List<Integer> reverseTernary = convertToTernary(n);
		int ret = convertTo10(reverseTernary);
		return ret;
	}

	public int convertTo10(List<Integer> reverseTernary) {
		int ret = 0;
		for (int i = 0; i < reverseTernary.size(); i++) {
 			int cof = i == 0 ? 1 : pow(i);
			ret += cof*reverseTernary.get(reverseTernary.size()-i-1);
		}
		return ret;
	}

	public int pow(int n) {
		if(n == 0) return 1;
		int base = 3;
		for (int i = 0; i < n-1; i++) {
			base *= 3;
		}
		return base;
	}

	public List<Integer> convertToTernary(int n) {
		List<Integer> ret = new ArrayList<>();
		while(n != 0) {
			ret.add(n%3);
			n /= 3;
		}
		return ret;
	}
}
