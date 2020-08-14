package backjoon.prince;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
백준 1004번 어린왕자
https://www.acmicpc.net/problem/1004
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			List<Integer> location =  Arrays.stream(br.readLine().split(" "))
					.map(p -> Integer.parseInt(p))
					.collect(Collectors.toList());
			Point start = new Point(location.get(0), location.get(1));
			Point end = new Point(location.get(2), location.get(3));
			int n = Integer.parseInt(br.readLine());

			List<Circle> circles = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				String[] centerInfo = br.readLine().split(" ");
				circles.add(new Circle(centerInfo));
			}
			List<Circle> circlesHavingStartPoint = circles.stream()
					.filter(circle -> circle.hasPoint(start))
					.collect(Collectors.toList());

			List<Circle> circlesHavingEndPoint = circles.stream()
					.filter(circle -> circle.hasPoint(end))
					.collect(Collectors.toList());

			Set<Circle> crossSectionCircles = crossSectionCircles(circlesHavingStartPoint, circlesHavingEndPoint);
			int answer = circlesHavingStartPoint.size() + circlesHavingEndPoint.size() - 2 * crossSectionCircles.size();
			System.out.println(answer);
		}
	}

	private static Set<Circle> crossSectionCircles(List<Circle> circlesHavingStartPoint, List<Circle> circlesHavingEndPoint) {
		Set<Circle> crossSectionSet = new HashSet<>();

		for (Circle startCircle : circlesHavingStartPoint) {
			for (Circle endCircle : circlesHavingEndPoint) {
				if(startCircle.equals(endCircle)) {
					crossSectionSet.add(endCircle);
				}
			}
		}

		return crossSectionSet;
	}
}

class Circle {
	Point center;
	int r;

	public Circle(String[] info) {
		this.center = new Point(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
		this.r = Integer.parseInt(info[2]);
	}

	public boolean hasPoint(Point point) {
		int dx = center.x - point.x;
		int dy = center.y - point.y;

		return r*r > (dx*dx + dy*dy);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Circle circle = (Circle) o;

		if (r != circle.r) return false;
		return center.equals(circle.center);
	}

	@Override
	public int hashCode() {
		int result = center.hashCode();
		result = 31 * result + r;
		return result;
	}
}

class Point {
	int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Point point = (Point) o;

		if (x != point.x) return false;
		return y == point.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}