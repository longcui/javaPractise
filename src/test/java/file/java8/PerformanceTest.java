package file.java8;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by long on 11.07.2017.
 */
public class PerformanceTest {

//    /**nearly same time
    @Test
    public void testLoopingList() {
        ArrayList<Integer> integers = new ArrayList<>();
        long cnt = 100000L;
        for (int i = 0; i < cnt; i++) {
            integers.add(i);
        }

        long l = System.currentTimeMillis();
        for (int i = 0; i < cnt; i++) {
            System.out.println(i);
        }
        long l1 = System.currentTimeMillis() - l;

        l = System.currentTimeMillis();
        integers.stream().forEach(System.out::println);
        long l2 = System.currentTimeMillis() - l;

        System.out.println("l1: " + l1 / 1000.0 + "ms'");
        System.out.println("l2: " + l2 / 1000.0 + "ms'");
    }

}
