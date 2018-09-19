package competition.equinorTest;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'minPower' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int minPower(List<Integer> p) {
    // Write your code here
//        int ini = 0;
        ArrayList<Integer> powers = new ArrayList<>();

        int total = 0;
        powers.add(total);
        for (Integer integer : p) {
            total += integer;
            powers.add(total);
        }

        int minst = Integer.MAX_VALUE;
        for (Integer power : powers) {
            if(power < minst) {
                minst = power;
            }
        }


        if(minst > 1) {
            return minst;
        } else {
            return 1 - minst;
        }

    }

    public  static void main(String[] args) {
        ArrayList<Integer> powers = new ArrayList<>();

        powers.add(-5);
        powers.add(4);
        powers.add(-2);
        powers.add(3);
        powers.add(1);
        minPower(powers);
    }

}