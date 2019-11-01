package javaCoreTest;

import org.junit.Assert;
import org.junit.Test;

public class StringExample {
    //a and b share the same address
    @Test
    public void testAddressId() {
        String a = "abcde";
        String b = "abcde";
        Assert.assertEquals(a, b);
    }
}
