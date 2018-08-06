import org.junit.Test;

import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void test1() {
        String message = "I am so so happy today, and I am not happy every day";
        String[] strings = Pattern.compile("\\s*[^\\p{IsAlphabetic}]+\\s*").split(message);
        System.out.println(String.join(" ", strings));
    }

    @Test
    public void test2() {
        String message = "I am so so happy today, and I am not happy every day";
        String[] strings = Pattern.compile("\\s*[^\\w}]+\\s*").split(message);
        System.out.println(String.join(" ", strings));
    }
}
