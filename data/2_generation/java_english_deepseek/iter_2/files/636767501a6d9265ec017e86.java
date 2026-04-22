import java.util.NoSuchElementException;

public class LinkedList<E> {
    private ListNode<E> current;

    // Assuming ListNode is a nested class within LinkedList
    private static class ListNode<E> {
        E data;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * {@inheritDoc}
     * Returns the previous node in the list.
     *
     * @return the previous node in the list
     * @throws NoSuchElementException if there is no previous node
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