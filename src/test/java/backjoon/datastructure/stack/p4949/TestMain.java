package backjoon.datastructure.stack.p4949;

import org.junit.Test;

public class TestMain {
	Main main = new Main();

	@Test
	public void isBalancedTest(){
		String a = " .";
		System.out.println(Main.isBalanced(a));
	}
}
