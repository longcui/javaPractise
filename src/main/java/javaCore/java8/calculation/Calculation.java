package javaCore.java8.calculation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Calculation {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(final long[] ar) {
        LongStream longStream = Arrays.stream(ar);
        return longStream.sum();

    }


    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int size = arr.size();
        int backwardSlackSum = 0;
        int slackSum = 0;

        for(int i = 0; i < size; i ++) {
            backwardSlackSum += arr.get(i).get(i);
            slackSum += arr.get(i).get(size - i - 1);
        }

        return Math.abs(backwardSlackSum - slackSum);

    }
}

