class ListNodeImpl<E> {
    E value;
    ListNodeImpl<E> next;
    ListNodeImpl<E> prev;

    ListNodeImpl(E value) {
        this.value = value;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;

    /** 
     * Remove the non null  {@code node} from the list. 
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // Node is head
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // Node is tail
        }

        node.next = null;
        node.prev = null;
        return true;
    }
}