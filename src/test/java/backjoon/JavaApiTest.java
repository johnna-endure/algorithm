package backjoon;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Arrays;

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


}
