package javaCoreTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListExamples {

    @Test
    public void test1() {
        int a = 1;
        int b = 2;
        List<Integer> list = Arrays.asList(a, b);
        list.set(0, 11);

        Assert.assertNotEquals(11, a);
    }

    @Test
    public void test2() {
        Integer[] a = {1, 2};
        List<Integer> ints = Arrays.asList(a);
        ints.set(0, 11);

        Assert.assertEquals(11, a[0].intValue());
    }
}
