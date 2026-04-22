import java.util.Iterator;

public class DoublyLinkedList<E> {

    private static class ListNodeImpl<E> {
        E data;
        ListNodeImpl<E> next;
        ListNodeImpl<E> prev;

        ListNodeImpl(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private ListNodeImpl<E> head;
    private ListNodeImpl<E> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addListNode(ListNodeImpl<E> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void removeListNode(ListNodeImpl<E> node) {
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
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
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