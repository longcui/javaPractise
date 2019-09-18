package competition;

import java.util.ArrayList;

/*
Interval questions with Miles as
 */

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Integer[] traverse(Node root) {
        ArrayList<Integer> rets = new ArrayList<>();
        Node node = root;
        while (node != null) {
            rets.add(node.data);
            node = node.next;
        }

        return rets.toArray(new Integer[rets.size()]);
    }

    public static Node reverseLinkedList(Node root) {
        Node a = root;
        Node b = root.next;

        //has only one node
        if(b == null) {
            return root;
        }

        Node c = root.next.next;

        root.next = null;

        while(b != null) {
            b.next = a;
            a = b;
            b = c;
            if(c != null) {
                c = c.next;
            }
        }

        return  a;

    }
}
