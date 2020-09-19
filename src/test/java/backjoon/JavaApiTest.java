package backjoon;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.smartcardio.Card;
import java.time.LocalTime;
import java.util.*;

public class JavaApiTest {
	//Array.clone
	@Test
	public void arrayCloneTest(){
		int[][] arr = {{1,2},{3,4}};

		int[][] clone = arr.clone();
		Arrays.stream(clone).forEach(a -> System.out.println(Arrays.toString(a)));

		clone[0][0] = 0;

		System.out.println(arr[0][0]);
	}

	@Test
	public void testBitOperation(){

		int a = 0;

		int b = a | 1<<2;
		System.out.println(a);
		System.out.println(b);
	}

	@Test
	public void printAlphabetChars(){
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println();


		System.out.println((int)'A'-65);
		System.out.println((int)'Z'-65);
		System.out.println((int)'a'-71);
		System.out.println((int)'z'-71);
	}

	@Test(timeout = 1000l)
	public void test(){
		Map<Integer, Card> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 500000; i++) {
			map.put(i, new Card(i,1));
		}

		Card[] cards = map.values().toArray(new Card[500000]);
		Arrays.sort(cards, Comparator.comparing(card -> card.number));
	}

	class Card {
		int number, size;

		public Card(int number, int size) {
			this.number = number;
			this.size = size;
		}

		public void increaseSize() {size++;}

		@Override
		public String toString() {
			return "Card{" +
					"number=" + number +
					", size=" + size +
					'}';
		}
	}

	@Test
	public void forLoopOnSet() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);

		for (int n : set) {
			System.out.println(n);
		}
	}

	@Test
	public void randomInt() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomInt(3,3));
		}
	}

	private int getRandomInt(int start, int end) {
		int offset = end-start;
		Random random = new Random();
		return random.nextInt(offset)+start;
	}

	@Test
	public void testCallByValue(){
	}

}
class Point {
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

