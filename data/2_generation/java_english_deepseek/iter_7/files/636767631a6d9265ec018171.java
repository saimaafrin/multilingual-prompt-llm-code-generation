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

class LinkedList<E> {
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

        node.next = null;
        node.prev = null;

        return true;
    }
}