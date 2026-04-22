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

        if (node == head) {
            head = head.next;
            return true;
        }

        ListNodeImpl<E> current = head;
        while (current.next != null) {
            if (current.next == node) {
                current.next = node.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}