import java.util.NoSuchElementException;

public class LinkedList<E> {
    
    private class ListNodeImpl<E> {
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
     * Remove the non null {@code node} from the list.
     */
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
        
        node.item = null;
        size--;
        return true;
    }
}