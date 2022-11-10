package code;

public class Node {
    int data;

    Node left, right;

    public  Node() {
        this(0, null, null);
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
