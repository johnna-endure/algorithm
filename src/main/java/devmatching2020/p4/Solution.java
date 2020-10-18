package devmatching2020.p4;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public String solution(String[] votes, int k) {
		HashMap<String,Integer> map = new HashMap<>();
		//맵에 저장
		for (int i = 0; i < votes.length; i++) {
			String carName = votes[i];
			if(map.containsKey(carName)) {
				int val = map.get(carName);
				map.replace(carName, val+1);
				continue;
			}
			map.put(carName, 1);
		}

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Comparator<Vote> comp = (a,b) -> {
			if(a.cnt == b.cnt) {
				return a.name.compareTo(b.name);
			}
			return b.cnt - a.cnt;
		};
		List<Vote> l = set.stream()
				.map(entry -> new Vote(entry.getKey(), entry.getValue()))
				.sorted(comp)
				.collect(Collectors.toList());

//		System.out.println(l);

		int headSum = l.stream()
				.limit(k)
				.map(v -> v.cnt)
				.reduce((a,b) -> a+b).get();

//		System.out.println(headSum);
		String ret = "";
		for (int i = 0; i < l.size(); i++) {
			int tailCnt = l.get(l.size()-1-i).cnt;
			if(headSum - tailCnt > 0) {
				headSum -= tailCnt;
				ret = l.get(l.size()-1-i).name;
			}else {
				break;
			}
		}
		return ret;
	}
}
class Vote {
	String name;
	int cnt;

	public Vote(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Vote{" +
				"name='" + name + '\'' +
				", cnt=" + cnt +
				'}';
	}
}