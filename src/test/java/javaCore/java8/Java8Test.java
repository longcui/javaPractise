package javaCore.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Java8Test {

    @Test
    public void test() {
        int[] ints = new ArrayList<String>().stream()
                .mapToInt(String::length)
                .toArray();
        Assert.assertEquals(0, ints.length);

    }
}
