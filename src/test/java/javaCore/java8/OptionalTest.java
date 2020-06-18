package javaCore.java8;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1() {
        Object o = Optional.ofNullable(null)
                .orElse(null);
    }
}
