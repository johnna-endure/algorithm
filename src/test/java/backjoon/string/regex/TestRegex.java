package backjoon.string.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRegex {

    @Test
    public void testRegex(){
		String input = "55-33+22";

	    Pattern pattern = Pattern.compile("[0-9]+|[\\-\\+]");
		Matcher matcher = pattern.matcher(input);

		while(matcher.find()) {
			System.out.println(matcher.group());
		}
    }

}
