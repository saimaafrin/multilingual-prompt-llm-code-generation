import java.util.NoSuchElementException;

public class LinkedList<E> {
    
    private static class ListNodeImpl<E> {
        E item;
        ListNodeImpl<E> next;
        ListNodeImpl<E> prev;

        ListNodeImpl(ListNodeImpl<E> prev, E element, ListNodeImpl<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNodeImpl<E> first;
    private ListNodeImpl<E> last;
    private int size = 0;

    /**
     * 从列表中移除非空的 {@code node}。
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        final ListNodeImpl<E> prev = node.prev;
        final ListNodeImpl<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return true;
    }
}