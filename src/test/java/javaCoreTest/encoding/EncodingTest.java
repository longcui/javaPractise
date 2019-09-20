package javaCoreTest.encoding;

import org.junit.Assert;
import org.junit.Test;

public class EncodingTest {
    @Test
    public void test() {
        String newLine = "\n";
        Assert.assertEquals(1, newLine.length());

        char c = newLine.charAt(0);
        Assert.assertEquals(10, c); //ASC 2 code: 10 means new line
    }
}
