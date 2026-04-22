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
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                // If the list becomes empty, update the tail as well
                tail = null;
            }
            return true;
        }

        // If the node to be removed is the tail
        if (node == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                // If the list becomes empty, update the head as well
                head = null;
            }
            return true;
        }

        // If the node is somewhere in the middle
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        return true;
    }
}