package backjoon.string.kmp;

import backjoon.string.kmp.p1786.KMPReader;
import org.junit.Test;

import java.util.Arrays;

public class KMPReaderTest {

	@Test
	public void setPiArrayTest() {
		KMPReader reader = new KMPReader("", "ABC");
		reader.setPiArray(1, 0,0);
		int[] ret = reader.getPiArray();

		System.out.println(Arrays.toString(ret));
	}

	@Test
	public void searchTest() {
		KMPReader reader = new KMPReader("DDDD", "BBDD");
		System.out.println(reader.search());
	}

	@Test
	public void searchMainTest() {
	}

	@Test
	public void forTest(){
	}

}
