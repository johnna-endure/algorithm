package devmatching2020.p2;

import java.time.LocalTime;

public class Solution {
	public String solution(String p, int n) {
		LocalTime time24 = convertTo24(p);
		LocalTime modifiedTime = time24.plusSeconds(n);

		return formatting(modifiedTime);
	}

	private String formatting(LocalTime modifiedTime) {
		int hour = modifiedTime.getHour();
		int minute = modifiedTime.getMinute();
		int second = modifiedTime.getSecond();
		return String.format("%02d:%02d:%02d",hour, minute, second);
	}

	public LocalTime convertTo24(String p)  {
		boolean isDay = p.startsWith("AM");
		String timeOnlyStr = p.substring(2).trim();

		if(isDay) {
			if(timeOnlyStr.startsWith("12")) return LocalTime.parse(timeOnlyStr.replaceFirst("12","00"));
			return LocalTime.parse(timeOnlyStr);
		}

		if(!timeOnlyStr.startsWith("12")) return LocalTime.parse(timeOnlyStr).plusHours(12);
		return LocalTime.parse(timeOnlyStr);
	}
}