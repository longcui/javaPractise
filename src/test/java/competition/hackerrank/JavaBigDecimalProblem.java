package competition.hackerrank;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class JavaBigDecimalProblem {

    @Test
    public void test() {
//        String[] strings = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        String[] strings = {"0", "0", "0", "0", "0"};
        String[] returned = sort(strings);
        System.out.println(Arrays.toString(returned));
    }

    private static String[] sort(String []s) {
        HashSet<String> enhancedInput = new HashSet<>();
        for (int i = 0; i < s.length; i ++) {
            String s1 = s[i];
            if(s1 != null && !s1.isEmpty()) {
                enhancedInput.add(s[i] + ", " + i);
            }
        }

        TreeSet<String> treeSet = new TreeSet<String>((String o1, String o2) -> {
            String[] splitO1 = o1.split(", ");
            String[] splitO2 = o2.split(", ");
            int compare = new BigDecimal(splitO1[0]).compareTo(new BigDecimal(splitO2[0]));
            if(compare == 0) {
                return Integer.compare(Integer.parseInt(splitO1[1]), Integer.parseInt(splitO2[1]));
            } else {
                return -compare;
            }
        });

        for (String s1 : enhancedInput) {
                treeSet.add(s1);
        }

        List<String> as = treeSet.stream()
                .map(value -> (String)value.split(", ")[0])
                .collect(Collectors.toList());

        return as.toArray(new String [as.size()]);
    }
}
