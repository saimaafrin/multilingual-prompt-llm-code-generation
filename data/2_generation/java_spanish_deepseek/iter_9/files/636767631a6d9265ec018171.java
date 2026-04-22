class ListNodeImpl<E> {
    E element;
    ListNodeImpl<E> next;
    ListNodeImpl<E> prev;

    ListNodeImpl(E element, ListNodeImpl<E> prev, ListNodeImpl<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;

    /**
     * Elimina el {@code node} no nulo de la lista.
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

        node.element = null; // Help GC
        return true;
    }
}