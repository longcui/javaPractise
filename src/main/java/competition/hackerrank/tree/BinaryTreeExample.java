package competition.hackerrank.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeExample {

    static List<Integer> heightList = Collections.synchronizedList(new ArrayList<Integer>());

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(Node root) {
        // Write your code here.
        getHeightList(root, 0);
        return heightList.stream()
                .reduce((integer, integer2) -> integer.compareTo(integer2) < 0 ? integer2 : integer)
                .get();
    }

    private static void getHeightList(Node node, int height) {
        if(node.left != null) {
            getHeightList(node.left, height + 1);
        }

        if(node.right != null) {
            getHeightList(node.right, height + 1);
        }

        if(node.left == null && node.right == null) {
            heightList.add(height);
        }

    }

}
