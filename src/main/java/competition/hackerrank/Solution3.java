package competition.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution3 {

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        int ret = 0;

        int[] normalizedS = IntStream.of(S)
                .map(s -> s % k)
                .toArray();

        HashMap<Integer, Integer> statistics = new HashMap<>(k);

        for (int s : normalizedS) {
            if(statistics.get(s) == null) {
                statistics.put(s, 0);
            }

            statistics.put(s, statistics.get(s) + 1);
        }

        int higherMid = (int)Math.ceil(k / 2.0);
        for(int i = 1; i < higherMid; i ++) {
            if(statistics.get(i) != null && statistics.get(k - i) != null) {
                ret += statistics.get(i) > statistics.get(k - i) ? statistics.get(i) : statistics.get(k - i);
            } else if(statistics.get(i) != null) {
                ret += statistics.get(i);
            } else if(statistics.get(k - i) != null) {
                ret += statistics.get(k - i);
            }
        }

        if(statistics.get(0) != null) {
            ret ++;
        }

        if(k % 2 == 0 && statistics.get(k / 2) != null) {
            ret ++;
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
