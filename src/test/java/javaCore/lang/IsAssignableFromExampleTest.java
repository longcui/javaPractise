package javaCore.lang;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsAssignableFromExampleTest {

    IsAssignableFromExample isAssignableFromExample = new IsAssignableFromExample();
    IsAssignableFromExample.SubClass subClass = new IsAssignableFromExample.SubClass();

    @Test(expected = ClassCastException.class)
    public void test() {
        subClass = (IsAssignableFromExample.SubClass) isAssignableFromExample;
    }

    @Test
    public void test1() {
        isAssignableFromExample = subClass;
    }

}