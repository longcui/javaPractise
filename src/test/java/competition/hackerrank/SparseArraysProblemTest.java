package competition.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SparseArraysProblemTest {

    @Test
    public void test() {
        String[] strings = {"aba", "baba", "aba", "xzxb"};
        String[] queries = {"aba", "xzxb", "ab"};
        int[] counts = SparseArraysProblem.matchingStrings(strings, queries);
        Assert.assertArrayEquals(new int[]{2, 1, 0}, counts);
    }

}