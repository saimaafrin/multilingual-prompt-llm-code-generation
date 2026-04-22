import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private static class ListNode<E> {
        E element;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E element, ListNode<E> next, ListNode<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode<E> head;
    private ListNode<E> tail;
    private ListNode<E> current;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        current = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListNode<E> previousNode() {
        if (current == null || current.prev == null) {
            throw new NoSuchElementException("No previous node available.");
        }
        current = current.prev;
        return current;
    }
}