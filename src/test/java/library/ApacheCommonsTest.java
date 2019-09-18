package library;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;


public class ApacheCommonsTest {
    @Test
    public void test() {
// ...
        String source = "The less than sign (<) and ampersand (&) must be escaped before using them in HTML";
        String escaped = StringEscapeUtils.escapeHtml4(source);
        Assert.assertEquals("The less than sign (&lt;) and ampersand (&amp;) must be escaped before using them in HTML", escaped);
    }
}
