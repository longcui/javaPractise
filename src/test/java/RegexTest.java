import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
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

    @Test
    public void test3() {
        String regex = "it is (not )?your fault.";
        String msg1 = "it is not your fault.";
        String msg2 = "it is your fault.";
        Assert.assertTrue(msg1.matches(regex));
        Assert.assertTrue(msg2.matches(regex));
    }

    @Test
    public void testBoundary() {
        String data1 = "Today, java is object oriented language";

        String regex = "\\bjava\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(data1);
        while (matcher.find())
        {
            Assert.assertEquals("Start index.", 7, matcher.start());
            Assert.assertEquals("End index.", 11, matcher.end());
        }

    }
}
