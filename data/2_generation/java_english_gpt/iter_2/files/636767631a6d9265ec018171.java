class ListNodeImpl<E> {
    E value;
    ListNodeImpl<E> next;
    
    ListNodeImpl(E value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;

    /** 
     * Remove the non null  {@code node} from the list. 
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null || head == null) {
            return false;
        }

        // If the node to be removed is the head
        if (node == head) {
            head = head.next;
            return true;
        }

        // Find the previous node
        ListNodeImpl<E> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }

        // If the node was not found
        if (current == null) {
            return false;
        }

        // Unlink the node
        current.next = node.next;
        return true;
    }
}