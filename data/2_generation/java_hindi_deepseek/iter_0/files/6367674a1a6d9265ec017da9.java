import java.util.Iterator;

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

    private void addListNode(ListNodeImpl<E> node) {
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

    private void removeListNode(ListNodeImpl<E> node) {
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
        if (list == null || list.size == 0) {
            return;
        }

        Iterator<ListNodeImpl<E>> iterator = list.iterator();
        while (iterator.hasNext()) {
            ListNodeImpl<E> node = iterator.next();
            list.removeListNode(node);
            this.addListNode(node);
        }
    }

    private Iterator<ListNodeImpl<E>> iterator() {
        return new Iterator<ListNodeImpl<E>>() {
            private ListNodeImpl<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public ListNodeImpl<E> next() {
                ListNodeImpl<E> node = current;
                current = current.next;
                return node;
            }
        };
    }
}