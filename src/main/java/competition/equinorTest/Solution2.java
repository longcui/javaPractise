package competition.equinorTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    // Complete the cutSticks function below.

    static int[] cutSticks(int[] lengths) {
        ArrayList<Integer> rets = new ArrayList<>();
        int cnt = getCnt(lengths);
        while (cnt > 0) {
            rets.add(cnt);
            lengths = process(lengths);
            cnt = getCnt(lengths);
        }

        return rets.stream()
                .mapToInt(i -> i)
                .toArray();

    }

    private static int[] process(int[] lengths) {
        int min =  Arrays.stream(lengths)
                .filter(value -> value > 0)
                .min().getAsInt();

        return Arrays.stream(lengths)
                .map(operand -> operand -= min)
                .toArray();
    }

    private static int getCnt(int[] lengths) {
        return (int) Arrays.stream(lengths)
                .filter(value -> value > 0)
                .count();
    }


}
