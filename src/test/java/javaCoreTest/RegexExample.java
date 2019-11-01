package javaCoreTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class RegexExample {
    @Test
    public void tet1() {
        Pattern pattern = Pattern.compile("[^\n]");
        Assert.assertTrue(pattern.matcher("f").matches());
//        Assert.assertTrue(pattern.matcher("abc.dfe.ftd.").matches());
    }

    @Test
    /**
     * You have a test string xxXxxXxxxx Your task is to match the pattern
     * Here x denotes a digit character, and X denotes a non-digit character.
     */
    public void tet2() {
        Pattern pattern = Pattern.compile("\\d\\d\\D\\d\\d\\D\\d\\d\\d\\d");
        Assert.assertTrue(pattern.matcher("f").matches());
//        Assert.assertTrue(pattern.matcher("abc.dfe.ftd.").matches());
    }

    @Test
    public void test3() {
        System.out.println("1\f2");
    }

    @Test
    public void test4() {
        Pattern pattern = Pattern.compile(".");
        Assert.assertTrue(pattern.matcher(".").matches());
        Assert.assertTrue(pattern.matcher("s").matches());
    }

    /**
     * not possible with regex: \.
     * Has to be \\.
     */
    @Test
    public void test5() {
        Pattern pattern = Pattern.compile("\\.");
        Assert.assertTrue(pattern.matcher(".").matches());
        Assert.assertFalse(pattern.matcher("s").matches());
    }
}
