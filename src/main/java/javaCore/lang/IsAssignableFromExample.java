package javaCore.lang;


public class IsAssignableFromExample {

    public static void  isAssignableFrom() {
        assert IsAssignableFromExample.class.isAssignableFrom(SubClass.class);
    }

    public static class SubClass extends IsAssignableFromExample {

    }
}
