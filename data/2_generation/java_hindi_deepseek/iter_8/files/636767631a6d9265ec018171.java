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

    public LinkedList() {
        this.head = null;
    }

    /**
     * सूची से गैर-शून्य {@code node} को हटा दें।
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        if (head == node) {
            head = head.next;
            return true;
        }

        ListNodeImpl<E> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        current.next = node.next;
        return true;
    }
}