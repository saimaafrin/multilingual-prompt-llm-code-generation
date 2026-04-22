import java.util.List;

public class ListNode<E> {
    private E element;
    private ListNode<E> next;
    private ListNode<E> previous;

    public ListNode(E element, ListNode<E> next, ListNode<E> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
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

    public ListNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<E> previous) {
        this.previous = previous;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListNode<E> previousNode() {
        return this.previous;
    }
}