import java.util.List;

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
        return this.prev;
    }
}