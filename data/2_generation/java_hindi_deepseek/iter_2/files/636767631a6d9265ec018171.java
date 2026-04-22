import java.util.Objects;

class ListNodeImpl<E> {
    E data;
    ListNodeImpl<E> next;

    ListNodeImpl(E data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * सूची से गैर-शून्य {@code node} को हटा दें।
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        if (head == null) {
            return false;
        }

        // If the node to be unlinked is the head
        if (head == node) {
            head = head.next;
            return true;
        }

        ListNodeImpl<E> current = head;
        while (current.next != null) {
            if (current.next == node) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Helper method to add elements to the list
    public void add(E data) {
        ListNodeImpl<E> newNode = new ListNodeImpl<>(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNodeImpl<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Helper method to print the list
    public void printList() {
        ListNodeImpl<E> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Original List:");
        list.printList();

        ListNodeImpl<Integer> nodeToRemove = list.head.next; // Node with value 2
        boolean removed = list.unlink(nodeToRemove);

        if (removed) {
            System.out.println("Node removed successfully.");
        } else {
            System.out.println("Node not found or list is empty.");
        }

        System.out.println("List after removal:");
        list.printList();
    }
}