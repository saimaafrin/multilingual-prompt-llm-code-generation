import java.util.List;

public class ListNode<E> {
    private E element;
    private ListNode<E> next;
    private ListNode<E> prev;

    public ListNode(E element, ListNode<E> next, ListNode<E> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getPrev() {
        return prev;
    }

    public void setPrev(ListNode<E> prev) {
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