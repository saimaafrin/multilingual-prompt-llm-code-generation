import java.util.Objects;

public class DoublyLinkedList<E> {

    private static class ListNode<E> {
        E element;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E element, ListNode<E> prev, ListNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void removeListNode(ListNode<E> node) {
        if (node == null) return;

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

    private void addListNode(ListNode<E> node) {
        if (node == null) return;

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list, "La lista no puede ser nula");

        if (list.head == null) return;

        ListNode<E> current = list.head;
        while (current != null) {
            ListNode<E> next = current.next;
            list.removeListNode(current);
            this.addListNode(current);
            current = next;
        }
    }
}