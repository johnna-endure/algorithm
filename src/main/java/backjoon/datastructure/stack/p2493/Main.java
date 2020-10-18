package backjoon.datastructure.stack.p2493;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

/*
탑
https://www.acmicpc.net/problem/2493
 */
public class Main {
	static int n;
	static int[] receivers;
	static Building[] buildings;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		n = reader.readInt();
		buildings = new Building[n+1];
		receivers = new int[n+1];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 1; i <= n; i++) {
			buildings[i] = new Building(i,Integer.parseInt(st.nextToken()));
		}

		solve();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(receivers[i]+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void solve() {
		Stack<Building> stack = new Stack<>();
		stack.add(buildings[1]);
		receivers[1] = 0;

		int index = 2;
		while(index <= n) {
			if(stack.isEmpty()) {
				stack.add(buildings[index]);
				receivers[index] = 0; index++;
				continue;
			}

			//top의 높이가 더 작으면 스택에 빼낸다.
			Building top = stack.peek();
			if(top.height < buildings[index].height) {
				stack.pop(); continue;
			}

			//top의 높이가 더 큰거나 같은 경우
			stack.add(buildings[index]);
			receivers[index] = top.id;
			index++;
		}

	}
}
class Building {
	int id, height;

	public Building(int id, int height) {
		this.id = id;
		this.height = height;
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
	public boolean ready() throws IOException {
		return br.ready();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}