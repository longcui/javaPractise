package competition.hackerrank.dictionaryAndHashmap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int ret = 0;
        int length = s.length();
        for (int l = 1; l < length; l++) {
            for (int i = 0; i + l <= length; i++) {
                for (int j = i + 1; j + l <= length; j++) {
                    String substringA = s.substring(i, i + l);
                    String substringB = s.substring(j, j + l);
                    if(isAnagram(substringA, substringB)) {
                        ret ++;
                    }
                }
            }
        }
        return ret;


    }

    static boolean isAnagram(String a, String b) {
        byte[] bytesA = a.getBytes();
        Arrays.sort(bytesA);

        byte[] bytesB = b.getBytes();
        Arrays.sort(bytesB);

        return  new String(bytesA).equals( new String(bytesB));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
