package competition.hackerrank.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeExampleTest {

    @Test
    public void test() {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(7);
        root.right.left = new Node(5);
        root.right.left.left = new Node(4);

        Assert.assertEquals(3, BinaryTreeExample.height(root));
    }

}