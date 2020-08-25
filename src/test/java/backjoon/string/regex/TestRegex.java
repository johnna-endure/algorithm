package backjoon.string.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRegex {

    @Test
    public void testRegex(){
	Pattern pattern = Pattern.compile("((100+1+)|(01))+");
	Matcher matcher = pattern.matcher("1000011010101");
	assertThat(matcher.matches()).isTrue();

	String s = matcher.group(1);
	System.out.println(s);
	System.out.println(matcher.groupCount());

	for (int i = 0; i < matcher.groupCount(); i++) {
	    System.out.println(matcher.group(i));
	}
    }
}
