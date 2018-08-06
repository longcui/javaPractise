package amazonTest;

import java.util.Stack;

/**
 * Created by long on 12.02.2017.
 */
public class Test2 {

    public static void main(String[] argss) {
        String a = "";
        String[] blocks = new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.println(totalScore(blocks, 8));
    }

    public static int totalScore(String[] blocks, int n) {
        // WRITE YOUR CODE HERE
        Stack<Integer> scores = new Stack<Integer>();
        int totalScore = 0;
        for (String block : blocks) {
            try {
                Integer integer = Integer.decode(block);
                scores.push(integer);
                totalScore += integer;
            } catch (NumberFormatException e) {
                if (block.equals("X")) {
                    Integer lastScore = 0;
                    if (scores.size() > 0) {
                        lastScore = scores.peek();
                    }
                    int score = lastScore * 2;
                    scores.push(score);
                    totalScore += score;
                } else if (block.equals("+")) {
                    if (scores.size() > 0) {
                        Integer lastScore = scores.pop();
                        Integer secondLastScore = 0;
                        if (scores.size() > 0) {
                            secondLastScore = scores.peek();
                        }
                        scores.push(lastScore);
                        int score = lastScore + secondLastScore;
                        scores.push(score);
                        totalScore += score;
                    }
                } else if (block.equals("Z")) {
                    if (scores.size() > 0) {
                        Integer lastScore = scores.pop();
                        totalScore -= lastScore;
                    }
                } else {
                    throw new IllegalArgumentException("Symbol could not be recoginised:" + block);
                }
            }
        }
        return totalScore;
    }
}
