class ListNodeImpl<E> {
    E value;
    ListNodeImpl<E> next;
    ListNodeImpl<E> prev;

    ListNodeImpl(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Remove the non null {@code node} from the list.
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        // If the node is the head
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        // If the node is the tail
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        // Clear the node's references
        node.next = null;
        node.prev = null;

        return true;
    }
}