import java.util.Iterator;

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

    public void addListNode(ListNode<E> node) {
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

    public void removeListNode(ListNode<E> node) {
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
        Iterator<ListNode<E>> iterator = list.iterator();
        while (iterator.hasNext()) {
            ListNode<E> node = iterator.next();
            list.removeListNode(node);
            this.addListNode(node);
        }
    }

    private Iterator<ListNode<E>> iterator() {
        return new Iterator<ListNode<E>>() {
            private ListNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public ListNode<E> next() {
                ListNode<E> node = current;
                current = current.next;
                return node;
            }
        };
    }
}