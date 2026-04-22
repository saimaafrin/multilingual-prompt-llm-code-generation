import java.util.NoSuchElementException;

public class LinkedList<E> {
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

    public LinkedList() {
        head = null;
        tail = null;
        current = null;
    }

    public void add(E element) {
        ListNode<E> newNode = new ListNode<>(element, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public void reset() {
        current = head;
    }

    public boolean hasNext() {
        return current != null;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E element = current.element;
        current = current.next;
        return element;
    }

    public boolean hasPrevious() {
        return current != null && current.prev != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListNode<E> previousNode() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        current = current.prev;
        return current;
    }
}