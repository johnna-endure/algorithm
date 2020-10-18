package backjoon.math.p2869;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
달팽이는 올라가고 싶다
https://www.acmicpc.net/problem/2869
 */
public class Main {
	static long a,b,v;
	public static void main(String[] args) throws IOException {
//		InputReader reader = new InputReader("testcase.txt");
		InputReader reader = new InputReader();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		v = Long.parseLong(st.nextToken());

		//범위를 좁힙니다.
		long day = (v-a)/(a-b); //자면서 이동한 날
		long remainder = (v-a)%(a-b); //남은 거리
		long rest = remainder + a; //자면서 이동한 거리를 제외한 나머지 거리


		while(true) {
			//남은 거리가 A보다 큰 경우 잠.
			if(rest > a) {
				rest -= (a-b);
				day++;
				continue;
			}
			//남은 거리가 A보다 작은 경우 종료.
			day++;
			break;
		}
		System.out.println(day);

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