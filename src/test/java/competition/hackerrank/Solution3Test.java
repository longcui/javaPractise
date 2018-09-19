package competition.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution3Test {

    @Test
    public void test() {
        int[] S = new int[]{1, 7, 2, 4};
        int k = 4;
        assertEquals(3, Solution3.nonDivisibleSubset(k, S));
    }

}