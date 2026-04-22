import java.util.NoSuchElementException;

class ListNode<E> {
    E data;
    ListNode<E> next;

    public ListNode(E data) {
        this.data = data;
        this.next = null;
    }

    public ListNode<E> previousNode() {
        if (this.next == null) {
            throw new NoSuchElementException("No previous node exists.");
        }
        ListNode<E> current = this;
        while (current.next != null && current.next != this) {
            current = current.next;
        }
        return current;
    }
}