package code;

public class Main {

    public static void main(String[] args) {
	    DoublyLinkedList list = new DoublyLinkedList();

	    final int ITEMS = 10;

	    for (int i = 0; i < ITEMS; ++i) {
	        list.add(i + 1);
        }

        System.out.println("\nList: " + list);

        System.out.println("\nRemoving 4 and 7...");
	    list.remove(4);
	    list.remove(7);

        System.out.println("List: " + list);

        System.out.println("\nReversing list");
	    list.reverse();

        System.out.println("List: " + list);
    }
}
