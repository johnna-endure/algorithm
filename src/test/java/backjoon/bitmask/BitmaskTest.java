package backjoon.bitmask;

import org.junit.Test;

public class BitmaskTest {
	@Test
	public void bitMask() {
		int a = 3;
		System.out.println(a | (1<<3));
		System.out.println(a);

	}

	@Test
	public void createFull1Bit() {
		int a = (1 << 3) -1;
		System.out.println(a);
	}
}
