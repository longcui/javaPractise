package java8.calculation;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Calculation {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(final long[] ar) {
        LongStream longStream = Arrays.stream(ar);
        return longStream.sum();

    }
}