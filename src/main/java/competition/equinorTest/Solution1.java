package competition.equinorTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution1 {
    private static HashSet<Integer>  endTag = new HashSet<>();
    private static HashMap<Integer, Integer> startEndTags = new HashMap<>();

    static {
        endTag.add((int)")".charAt(0));
        endTag.add((int)"]".charAt(0));
        endTag.add((int)"}".charAt(0));

        startEndTags.put((int)")".charAt(0), (int)"(".charAt(0));
        startEndTags.put((int)"]".charAt(0), (int)"[".charAt(0));
        startEndTags.put((int)"}".charAt(0), (int)"{".charAt(0));
    }

    // Complete the braces function below.
    static String[] braces(String[] values) {
//        return Arrays.stream(values)
//                .map(v -> brace(v))
//                .collect(Collectors.toList())
//                .toArray(new String[values.length]);
        String[] rets = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            rets[i] = brace(values[i]);
        }
        return rets;
    }

    private static String brace(String value) {
        Stack<Integer> stringStack = new Stack<>();
        for (char c : value.toCharArray()) {
            if(!endTag.contains((int)c)) {
                stringStack.push((int)c);
            } else if(!stringStack.empty()){
                Integer pop = stringStack.pop();
                if(pop.intValue() != startEndTags.get((int)c)) {
                    return "NO";
                }
            } else {
                    return "NO";
            }
        }

        return stringStack.empty() ? "YES" : "NO";
    }
}
