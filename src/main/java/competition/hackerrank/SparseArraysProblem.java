package competition.hackerrank;

import java.util.HashMap;

public class SparseArraysProblem {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> targetStringsMap = getTargetStringsMap(strings);
        int length = queries.length;
        int[] counts = new int[length];
        for(int i = 0; i < length; i ++) {
            String target = queries[i];
            Integer count = targetStringsMap.get(target);
            counts[i] = count == null? 0 : count;
        }
        return counts;
    }

    private static HashMap<String, Integer> getTargetStringsMap(String[] strings) {
        HashMap<String, Integer> stringCountMap = new HashMap<>();
        for (String string : strings) {
            Integer integer = stringCountMap.get(string);
            if (integer == null) {
                stringCountMap.put(string, 1);
            } else {
                stringCountMap.put(string, integer + 1);
            }
        }
        return stringCountMap;
    }

}
