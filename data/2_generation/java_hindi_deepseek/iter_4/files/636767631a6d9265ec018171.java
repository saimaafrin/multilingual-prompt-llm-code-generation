// Assuming ListNodeImpl is a class that represents a node in a linked list
// and it has a reference to the next node and possibly the previous node.

class ListNodeImpl<E> {
    E data;
    ListNodeImpl<E> next;
    ListNodeImpl<E> prev;

    ListNodeImpl(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * सूची से गैर-शून्य {@code node} को हटा दें।
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        // If the node to be removed is the head
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            } else {
                // If head is null, the list is empty, so tail should also be null
                tail = null;
            }
        } else if (node == tail) {
            // If the node to be removed is the tail
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                // If tail is null, the list is empty, so head should also be null
                head = null;
            }
        } else {
            // If the node is somewhere in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Clear the node's references
        node.next = null;
        node.prev = null;

        return true;
    }
}