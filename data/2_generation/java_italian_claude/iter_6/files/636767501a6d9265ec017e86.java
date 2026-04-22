import java.util.NoSuchElementException;

public class LinkedList<E> {
    private class ListNode<E> {
        private E data;
        private ListNode<E> next;
        private ListNode<E> prev;
        
        public ListNode(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private ListNode<E> current;

    /**
     * Returns the previous node in the linked list
     * @return The previous ListNode
     * @throws NoSuchElementException if there is no previous node
     */
    @Override
    public ListNode<E> previousNode() {
        if (current == null || current.prev == null) {
            throw new NoSuchElementException("No previous node exists");
        }
        current = current.prev;
        return current;
    }
}