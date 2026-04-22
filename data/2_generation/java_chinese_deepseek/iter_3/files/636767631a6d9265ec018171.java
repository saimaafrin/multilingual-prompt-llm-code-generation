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
     * 从列表中移除非空的 {@code node}。
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        ListNodeImpl<E> prevNode = node.prev;
        ListNodeImpl<E> nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }

        node.prev = null;
        node.next = null;

        return true;
    }
}