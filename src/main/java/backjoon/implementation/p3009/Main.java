package backjoon.implementation.p3009;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader("testcase.txt");
//		InputReader reader = new InputReader();

		List<Point> points = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());

			points.add(new Point(x,y));
		}

		Point center = getCenter(points);
//		System.out.println(center);
		double rest_x = 0;
		double rest_y = 0;
		for (int i = 0; i < 3; i++) {
			rest_x += points.get(i).x;
			rest_y += points.get(i).y;
		}
		double ans_x = (4*center.x) - rest_x;
		double ans_y = (4*center.y) - rest_y;
		System.out.println((int)ans_x+" "+(int)ans_y);
	}

	private static Point getCenter(List<Point> points) {
		for (int i = 0; i < points.size(); i++) {
			Point point = points.get(i);
			for (int j = i+1; j < points.size(); j++) {
				Point comparingPoint = points.get(j);
				if(notSameXAndY(point, comparingPoint)){
					return new Point((point.x + comparingPoint.x)/2, (point.y + comparingPoint.y)/2);
				}
			}
		}
		return null;
	}

	private static boolean notSameXAndY(Point point, Point comparingPoint) {
		if(point.x != comparingPoint.x && point.y != comparingPoint.y) return true;
		return false;
	}
}
class Point{
	double x,y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "{x=" + x +
				", y=" + y +
				'}';
	}
}
class InputReader {
	private BufferedReader br;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public InputReader(String filepath) {
		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
}

