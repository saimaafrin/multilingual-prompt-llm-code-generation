import java.util.NoSuchElementException;

public class LinkedList<E> {
    
    private class ListNodeImpl<E> {
        E element;
        ListNodeImpl<E> next;
        ListNodeImpl<E> prev;
        
        ListNodeImpl(E element, ListNodeImpl<E> prev, ListNodeImpl<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private ListNodeImpl<E> first;
    private ListNodeImpl<E> last;
    private int size;
    
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }
        
        final ListNodeImpl<E> prev = node.prev;
        final ListNodeImpl<E> next = node.next;
        
        if (prev == null) {
            // Node is the first element
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        
        if (next == null) {
            // Node is the last element
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        
        node.element = null;
        size--;
        return true;
    }
}