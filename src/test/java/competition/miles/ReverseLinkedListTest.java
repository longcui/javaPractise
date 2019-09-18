package competition.miles;

import competition.ReverseLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTest {
    @Test
    public void test1() {
        ReverseLinkedList.Node node4 = new ReverseLinkedList.Node(4, null);
        ReverseLinkedList.Node node3 = new ReverseLinkedList.Node(3, node4);
        ReverseLinkedList.Node node2 = new ReverseLinkedList.Node(2, node3);
        ReverseLinkedList.Node node1 = new ReverseLinkedList.Node(1, node2);
        ReverseLinkedList.Node node0 = new ReverseLinkedList.Node(0, node1);

        Assert.assertArrayEquals(ReverseLinkedList.traverse(ReverseLinkedList.reverseLinkedList(node0)), new Integer[]{4, 3, 2, 1, 0});
    }


    @Test
    public void test2() {
        ReverseLinkedList.Node node4 = new ReverseLinkedList.Node(4, null);

        Assert.assertArrayEquals(ReverseLinkedList.traverse(ReverseLinkedList.reverseLinkedList(node4)), new Integer[]{4});
    }

    @Test
    public void test3() {
        ReverseLinkedList.Node node4 = new ReverseLinkedList.Node(4, null);
        ReverseLinkedList.Node node3 = new ReverseLinkedList.Node(3, node4);


        Assert.assertArrayEquals(ReverseLinkedList.traverse(ReverseLinkedList.reverseLinkedList(node3)), new Integer[]{4, 3});
    }

    @Test
    public void test4() {
        ReverseLinkedList.Node node4 = new ReverseLinkedList.Node(4, null);
        ReverseLinkedList.Node node3 = new ReverseLinkedList.Node(3, node4);
        ReverseLinkedList.Node node2 = new ReverseLinkedList.Node(2, node3);

        Assert.assertArrayEquals(ReverseLinkedList.traverse(ReverseLinkedList.reverseLinkedList(node2)), new Integer[]{4, 3, 2});
    }

}