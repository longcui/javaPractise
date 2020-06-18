package javaCore.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8 {

    public class Staff {

        private String name;
        private int age;
        private BigDecimal salary;

        public Staff(String name, int age, BigDecimal salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }
    }

    public void test1() {
        List<Staff> staffList = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        try {
            staffList.clear();
        } catch (UnsupportedOperationException e){
            //            I think you may be using the Arrays utility to get the List that you pass into that method.
            // The object is indeed of type ArrayList, but it's java.util.Arrays.ArrayList, not java.util.ArrayList.
            //            The java.util.Arrays.ArrayList version is immutable and its remove() method is not overridden.
            // As such, it defers to the AbstractList implementation of remove(), which throws an UnsupportedOperationException.
            System.out.println("here it throws exception.");
        }


        try {
            staffList.remove(0);
        } catch (UnsupportedOperationException e){
            //            I think you may be using the Arrays utility to get the List that you pass into that method.
            // The object is indeed of type ArrayList, but it's java.util.Arrays.ArrayList, not java.util.ArrayList.
            //            The java.util.Arrays.ArrayList version is immutable and its remove() method is not overridden.
            // As such, it defers to the AbstractList implementation of remove(), which throws an UnsupportedOperationException.
            System.out.println("here it throws exception.");
        }


        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staffList) {
            result.add(x.getName());
        }
        System.out.println(result); //[mkyong, jack, lawrence]

        //Java 8
        List<String> collect = staffList.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect); //[mkyong, jack, lawrence]

        List<String> emptyCollect = new ArrayList<String>().stream().map(s -> s.toString()).collect(Collectors.toList());
        System.out.println(emptyCollect);
    }

    public static void main(String[] args) {
        TestJava8 testJava8 = new TestJava8();
        testJava8.test1();

    }

}