package backjoon;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {


	@Test
	public void testLog2(){
		System.out.println(log2(2));
	}
	private static int log2(int n) {
		if(n == 0) return 0;
		int cnt = 0;
		while(true) {
			n /= 2;
			cnt++;
			if(n == 0) break;
		}
		return cnt-1;
	}
}


