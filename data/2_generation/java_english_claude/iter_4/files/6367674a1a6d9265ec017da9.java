import java.util.Objects;

public class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    private static class ListNode<E> {
        E element;
        ListNode<E> prev;
        ListNode<E> next;

        ListNode(E element) {
            this.element = element;
        }
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list);
        
        if (list == this || list.size == 0) {
            return;
        }

        // If this list is empty, just point to the other list's nodes
        if (size == 0) {
            this.head = list.head;
            this.tail = list.tail;
        } else {
            // Connect the tail of this list to head of other list
            this.tail.next = list.head;
            list.head.prev = this.tail;
            this.tail = list.tail;
        }

        // Update size
        this.size += list.size;

        // Clear the other list
        list.head = null;
        list.tail = null;
        list.size = 0;
    }
}