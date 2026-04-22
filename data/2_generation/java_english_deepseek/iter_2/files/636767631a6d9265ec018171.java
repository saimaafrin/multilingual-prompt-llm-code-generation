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
     * Remove the non null {@code node} from the list.
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        ListNodeImpl<E> prev = node.prev;
        ListNodeImpl<E> next = node.next;

        if (prev == null) {
            // Node is the head
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            // Node is the tail
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.value = null; // Help GC
        return true;
    }
}