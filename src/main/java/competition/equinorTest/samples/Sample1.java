package competition.equinorTest.samples;

import java.util.List;
import java.util.Optional;

public class Sample1 {
    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
        Optional<Integer> found = arr.stream()
                .filter(integer -> k == integer)
                .findFirst();

        return found.isPresent()? "YES" : "NO";
    }


}
