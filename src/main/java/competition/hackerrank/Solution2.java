package competition.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution2 {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        if(a.size() != 3 || b.size() != 3) {
            throw new IllegalArgumentException("input size error.");
        }

        ArrayList<Integer> rets = new ArrayList<>();
        Integer aScore = 0;
        Integer bScore = 0;

        for(int i = 0; i < 3; i ++){
            Integer ai = a.get(i);
            Integer bi = b.get(i);
            if(!ai.equals(bi)) {
                if(ai > bi) {
                    aScore ++;
                } else {
                    bScore ++;
                }
            }
        }

        rets.add(aScore);
        rets.add(bScore);

        return rets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
