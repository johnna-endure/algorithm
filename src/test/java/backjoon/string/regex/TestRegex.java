package backjoon.string.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRegex {

    @Test
    public void testRegex(){
		String a = "112233";
	    System.out.println(merge(a));
    }

    public String merge(String line) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < line.length(); i++) {
		    if(i < line.length()-1 &&  line.charAt(i) == line.charAt(i+1)) {
			    int a = line.charAt(i) - 48;
			    int b = line.charAt(i+1) - 48;
			    sb.append(a+b);
			    i++;
			    continue;
		    }
		    sb.append(line.charAt(i));
	    }
	    while(sb.length() != line.length()) {
		    sb.append("0");
	    }

	    return sb.toString();
    }

}
