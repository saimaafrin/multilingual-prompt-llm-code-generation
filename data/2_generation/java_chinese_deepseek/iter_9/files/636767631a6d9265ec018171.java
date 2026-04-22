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
     * 从列表中移除非空的 {@code node}。
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        ListNodeImpl<E> prevNode = node.prev;
        ListNodeImpl<E> nextNode = node.next;

        if (prevNode == null) {
            // Node is the head
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) {
            // Node is the tail
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }

        node.value = null; // Help GC
        return true;
    }
}