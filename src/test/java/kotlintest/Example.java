package kotlintest;

import org.junit.Test;

public class Example {

	@Test
	public void testString() {
		String a = "1234";
		for (int i = a.length()-1; i >= 0; i--) {
			System.out.println(a.charAt(i));
		}
	}
}
