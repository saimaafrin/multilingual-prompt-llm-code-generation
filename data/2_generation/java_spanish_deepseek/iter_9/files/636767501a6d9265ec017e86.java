import java.util.List;

public class ListNode<E> {
    private E data;
    private ListNode<E> next;
    private ListNode<E> previous;

    public ListNode(E data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
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
    public ListNode<E> nodoAnterior() {
        return this.previous;
    }
}