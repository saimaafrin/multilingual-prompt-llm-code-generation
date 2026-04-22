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

    public void setCurrent(ListNode<E> node) {
        this.current = node;
    }

    public ListNode<E> getCurrent() {
        return current;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListNode<E> previousNode() {
        if (current == null) {
            throw new NoSuchElementException("No current node is set.");
        }
        if (current.prev == null) {
            throw new NoSuchElementException("No previous node exists.");
        }
        current = current.prev;
        return current;
    }
}