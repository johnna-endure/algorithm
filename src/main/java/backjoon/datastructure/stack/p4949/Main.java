package backjoon.datastructure.stack.p4949;


import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
//		InputReader reader = new InputReader("testcase.txt");
		StringBuilder sb = new StringBuilder();
		while(true) {
			String line = reader.readLine();
			if(line.equals(".")) break;

			if (isBalanced(line)) sb.append("yes\n");
			else sb.append("no\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	public static boolean isBalanced(String line) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(c == '(' || c == '[') {
				stack.add(c);
			}

			if(c == ')') {
				if(stack.isEmpty() || stack.peek() != '(') return false;
				stack.pop();
			}

			if(c == ']') {
				if(stack.isEmpty() ||stack.peek() != '[') return false;
				stack.pop();
			}
		}

		if(stack.isEmpty()) return true;
		return false;
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
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}
