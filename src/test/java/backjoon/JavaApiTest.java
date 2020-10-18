package backjoon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JavaApiTest {

	@Test
	public void printAlphabetChars(){
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println();

		System.out.println((int)'0');
		System.out.println((int)'9');
	}


	@Test
	public void a() {
		String hello = "hello";
		System.out.println(hello.substring(1));
		System.out.println(hello.substring(0,0));
	}
}

