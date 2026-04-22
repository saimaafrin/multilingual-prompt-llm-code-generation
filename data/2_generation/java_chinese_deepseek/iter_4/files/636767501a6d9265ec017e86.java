import java.util.NoSuchElementException;

public class ListNode<E> {
    private E data;
    private ListNode<E> next;
    private ListNode<E> prev;

    public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListNode<E> previousNode() {
        if (prev == null) {
            throw new NoSuchElementException("No previous node available.");
        }
        return prev;
    }
}