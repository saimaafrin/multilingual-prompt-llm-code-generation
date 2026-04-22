// Assuming ListNodeImpl is a class that represents a node in a linked list
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

    // Constructor and other methods of the LinkedList class would go here

    /**
     * Rimuove il nodo non nullo {@code node} dalla lista.
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        // If the node to be removed is the head
        if (node == head) {
            head = head.next;
            return true;
        }

        // Traverse the list to find the node before the one to be removed
        ListNodeImpl<E> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }

        // If the node was found, unlink it
        if (current != null) {
            current.next = node.next;
            return true;
        }

        // If the node was not found in the list
        return false;
    }
}