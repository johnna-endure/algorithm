package backjoon.datastructure.hashing.p1620;

import java.io.*;
import java.util.*;

/*
나는야 포켓몬 마스터 이다솜
https://www.acmicpc.net/problem/1620
 */
public class Main {
	static int n,m;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> findPokemon = new HashMap<>();
		HashMap<String, Integer> findNumber = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String pokemon = reader.readLine();
			findPokemon.put(i, pokemon);
			findNumber.put(pokemon, i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String command = reader.readLine();
			if(command.matches("[0-9]+")) {
				int number = Integer.parseInt(command);
				sb.append(findPokemon.get(number) + "\n");
			}else {
				sb.append(findNumber.get(command) + "\n");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
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

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
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
