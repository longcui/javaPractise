package competition.hackerrank;

import com.sun.source.tree.BinaryTree;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class JavaBigDecimalProblem {

    @Test
    public void test() {
//        String[] strings = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        String[] strings = {"0", "0", "0", "0", "0",};
        String[] returned = sort(strings);
        System.out.println(Arrays.toString(returned));
    }

    private static String[] sort(String []s) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (int i = 0; i < s.length; i ++) {
            String s1 = s[i];
            if(s1 != null && !s1.isEmpty()) {
                stringIntegerHashMap.put(s1, i);
            }
        }

        TreeSet<String> treeSet = new TreeSet<String>((String o1, String o2) -> {
            int compare = new BigDecimal(o1).compareTo(new BigDecimal(o2));
            if(compare == 0) {
                return stringIntegerHashMap.get(o1).compareTo(stringIntegerHashMap.get(o2));
            } else {
                return -compare;
            }
        });
        for (String s1 : stringIntegerHashMap.keySet()) {
                treeSet.add(s1);
        }
        return treeSet.toArray(new String [treeSet.size()]);
    }
}
