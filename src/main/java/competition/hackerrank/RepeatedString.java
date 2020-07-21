package competition.hackerrank;

/**
 * https://www.hackerrank.com/challenges/repeated-string/
 */
public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int length = s.length();
        long letterACnt = getLetterACnt(s);
        long multiplier = n / length;
        //if using (int) n % length; it means to convert n to int!!!
        int restStrCnt = (int)(n % length);

        long lastPartLetterACnt = getLetterACnt(s.substring(0, restStrCnt));

        return letterACnt * multiplier + lastPartLetterACnt;
    }

    private static long getLetterACnt(String s){
        return s.chars()
                .filter(c -> c == 'a')
                .count();
    }
}
