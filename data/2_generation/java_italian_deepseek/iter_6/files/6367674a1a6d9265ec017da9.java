import java.util.Objects;

public class DoublyLinkedList<E> {

    private static class ListNodeImpl<E> {
        E element;
        ListNodeImpl<E> prev;
        ListNodeImpl<E> next;

        ListNodeImpl(E element, ListNodeImpl<E> prev, ListNodeImpl<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addListNode(ListNodeImpl<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void removeListNode(ListNodeImpl<E> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
        size--;
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list, "The input list cannot be null");

        if (list.head == null) {
            return; // Nothing to move
        }

        // If this list is empty, just take over the other list's nodes
        if (this.head == null) {
            this.head = list.head;
            this.tail = list.tail;
        } else {
            // Append the other list's nodes to this list
            this.tail.next = list.head;
            list.head.prev = this.tail;
            this.tail = list.tail;
        }

        // Update the size of this list
        this.size += list.size;

        // Clear the other list
        list.head = null;
        list.tail = null;
        list.size = 0;
    }
}