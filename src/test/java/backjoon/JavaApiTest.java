package backjoon;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.smartcardio.Card;
import java.time.LocalTime;
import java.util.*;

public class JavaApiTest {

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
		System.out.println();

		System.out.println((int)'0' - 48);
		System.out.println((int)'1' - 48);
	}

}

