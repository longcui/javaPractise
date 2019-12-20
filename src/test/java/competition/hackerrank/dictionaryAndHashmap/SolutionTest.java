package competition.hackerrank.dictionaryAndHashmap;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(4, Solution.sherlockAndAnagrams("abba"));
    }

    @Test
    public void test1() {
        Assert.assertTrue(Solution.isAnagram("ab", "ba"));
    }

}