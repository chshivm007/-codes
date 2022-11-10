package code;

public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public int remove(Object key) {
        if (head == null)
            return -1;

        if (head.data == key) {
            head = null;
            return 0;
        }

        Node toDelete = head;

        while (toDelete != null) {

            if (toDelete.data == key) {
                Node prevNode = toDelete.prev;
                Node afterNode = toDelete.next;
                prevNode.next = afterNode;
                afterNode.prev = prevNode;
                return 0;
            }

            toDelete = toDelete.next;
        }
        if (toDelete.data == key) {
            toDelete = toDelete.prev;
            toDelete.next = null;
            return 0;
        }
        return -1;
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node curNode = head;

        do {
            Node temp = curNode.next;
            curNode.next =  curNode.prev;
            curNode.prev = temp;

            curNode = curNode.prev;

        } while (curNode.next != null);

        head = curNode;
        head.next = curNode.prev;
        head.prev = null;
    }

    public void add(Object info) {
        if (head == null) {
            head = new Node(info);
            return;
        }
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        traverse.next = new Node(info);
        traverse.next.prev = traverse;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder res = new StringBuilder("[");

        Node curNode = head;

        while (curNode.next != null) {
            res.append(curNode.data).append(", ");
            curNode = curNode.next;
        }

        res.append(curNode.data).append("]");

        return res.toString();
    }
}
