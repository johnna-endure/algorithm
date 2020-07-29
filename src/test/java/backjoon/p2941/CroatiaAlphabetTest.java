package backjoon.p2941;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CroatiaAlphabetTest {

	String[] croAlphabetArray = {
			"c=","c-","dz=","d-",
			"lj","nj","s=","z="
	};
	@Test
	public void testGetCnt(){
		assertThat(Main.getCnt("ljes=njak" , 0 ,croAlphabetArray),is(6));
	}
}
