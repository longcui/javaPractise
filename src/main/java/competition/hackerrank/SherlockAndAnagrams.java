package competition.hackerrank;

import java.util.Arrays;

public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int cnt = 0;
        int length = s.length();
        for(int i = 1; i < length; i ++) {
            for(int j = 0; j <= length - i; j ++) {
                cnt += getPairCnt(j, s.substring(j, j + i), s);
            }
        }
        return cnt;

    }

    private static int getPairCnt(int j, String substring, String s) {
        int localCnt = 0;
        int subLength = substring.length();
        for(int k = j + 1; k <= s.length() - subLength; k ++) {
            if(isAPair(substring, s.substring(k, k + subLength))) {
                localCnt ++;
            }
        }
        return localCnt;
    }

    private static boolean isAPair(String strA, String strB) {
        char[] a = strA.toCharArray();
        char[] b = strB.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.equals(a, b)) {
            return true;
        } else {
            return false;
        }
    }
}
