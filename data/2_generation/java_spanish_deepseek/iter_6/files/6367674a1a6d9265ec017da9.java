import java.util.Objects;

public class DoublyLinkedList<E> {

    private static class ListNodeImpl<E> {
        E element;
        ListNodeImpl<E> next;
        ListNodeImpl<E> prev;

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
            throw new NullPointerException("Node cannot be null");
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
            throw new NullPointerException("Node cannot be null");
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
        node.next = null;
        node.prev = null;
        size--;
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
        if (list == null) {
            throw new NullPointerException("List cannot be null");
        }
        if (list.head == null) {
            return;
        }

        ListNodeImpl<E> current = list.head;
        while (current != null) {
            ListNodeImpl<E> nextNode = current.next;
            list.removeListNode(current);
            this.addListNode(current);
            current = nextNode;
        }
    }

    // Other methods of DoublyLinkedList...
}