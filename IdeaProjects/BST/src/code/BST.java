package code;

public class BST {

    Node root = null;

    public void insert(int data) {
        if (root == null)
            root = new Node(data);
        else {
            if (data < root.data) {
                if (root.left == null)
                    root = new Node(data);
                else
            }
        }
    }
}
