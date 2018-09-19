package competition.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class SherlockAndAnagramsTest {

    @Test
    public void test1() {
        assertEquals(2, SherlockAndAnagrams.sherlockAndAnagrams("mom"));
    }

    @Test
    public void test2() {
        assertEquals(4, SherlockAndAnagrams.sherlockAndAnagrams("abba"));
    }

    @Test
    public void test3() {
        assertEquals(0, SherlockAndAnagrams.sherlockAndAnagrams("abcd"));
    }

    @Test
    public void test4() {
        assertEquals(3, SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq"));
    }

    @Test
    public void test5() {
        assertEquals(10, SherlockAndAnagrams.sherlockAndAnagrams("kkkk"));
    }


}