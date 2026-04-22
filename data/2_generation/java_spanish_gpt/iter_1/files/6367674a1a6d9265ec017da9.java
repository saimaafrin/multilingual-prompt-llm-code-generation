import java.util.NoSuchElementException;

class ListNode<E> {
    E data;
    ListNode<E> next;
    ListNode<E> prev;

    ListNode(E data) {
        this.data = data;
    }
}

class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;

    public void addListNode(ListNode<E> node) {
        if (node == null) return;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void removeListNode(ListNode<E> node) {
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
        node.next = null;
        node.prev = null;
    }

    private void moveAllListNodes(DoublyLinkedList<E> list) {
        if (list == null || list.head == null) return;

        ListNode<E> current = list.head;
        while (current != null) {
            ListNode<E> nextNode = current.next;
            list.removeListNode(current);
            this.addListNode(current);
            current = nextNode;
        }
    }
}