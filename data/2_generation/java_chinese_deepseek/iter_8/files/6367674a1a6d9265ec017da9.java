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
        Objects.requireNonNull(node, "Node cannot be null");

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
        Objects.requireNonNull(node, "Node cannot be null");

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
        Objects.requireNonNull(list, "List cannot be null");

        ListNodeImpl<E> current = list.head;
        while (current != null) {
            ListNodeImpl<E> next = current.next;
            list.removeListNode(current);
            this.addListNode(current);
            current = next;
        }
    }
}