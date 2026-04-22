import java.util.LinkedList;

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
        ListNode<E> current = head;
        while (current != null) {
            ListNode<E> nextNode = current.next; // Store next node
            removeListNode(current); // Remove from current list
            list.addListNode(current); // Add to the new list
            current = nextNode; // Move to the next node
        }
    }
}