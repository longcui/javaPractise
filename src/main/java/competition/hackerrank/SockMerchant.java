package competition.hackerrank;

import java.util.HashMap;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        HashMap<Integer, Integer> sockCountMap = new HashMap<>();
        for (int sockColor : ar) {
            sockCountMap.put(sockColor, sockCountMap.getOrDefault(sockColor, 0) + 1);
        }

        for (Integer sockColor : sockCountMap.keySet()) {
            pairs += sockCountMap.get(sockColor) / 2;
        }

        return pairs;
    }

}
