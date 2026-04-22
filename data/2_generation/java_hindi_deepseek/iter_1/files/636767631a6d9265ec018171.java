class ListNodeImpl<E> {
    E data;
    ListNodeImpl<E> next;

    ListNodeImpl(E data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<E> {
    private ListNodeImpl<E> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * सूची से गैर-शून्य {@code node} को हटा दें।
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null || head == null) {
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

        return false; // Node not found
    }
}