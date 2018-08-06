package amazonTest;

public class Solution {
    public static Node root;

    public Solution() {
        this.root = null;
    }

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public static void main(String arg[]) {
        int []values = new int[]{5, 6, 3, 1, 2, 4};
        System.out.println(bstDistance(values, 1, 2, 9));
    }

    public static int bstDistance(int[] values, int n, int node1, int node2) {
        Solution b = new Solution();
        for (int value : values) {
            b.insert(value);
        }

        int x = Pathlength(b.root, node1) - 1;
        int y = Pathlength(b.root, node2) - 1;
        if(x == -1 || y == -1){
            return -1;
        }
        int lcaData = findLCA(b.root, node1, node2).data;
        int lcaDistance = Pathlength(b.root, lcaData) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public static int Pathlength(Node root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
                    || (x = Pathlength(root.right, n1)) > 0) {
                // System.out.println(root.data);
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public static Node findLCA(Node root, int n1, int n2) {
        if (root != null) {
            if (root.data == n1 || root.data == n2) {
                return root;
            }
            Node left = findLCA(root.left, n1, n2);
            Node right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}