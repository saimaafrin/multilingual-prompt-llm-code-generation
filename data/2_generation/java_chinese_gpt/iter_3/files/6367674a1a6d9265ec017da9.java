public class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;

    private static class ListNode<E> {
        E data;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E data) {
            this.data = data;
        }
    }

    /**
     * 原子性地将所有 {@link ListNode ListNodes} 从 {@code list} 移动到此列表，就像每个节点都是通过 {@link #removeListNode(ListNodeImpl)} 从 {@code list} 中移除的，然后依次通过 {@link #addListNode(ListNodeImpl)} 添加到此列表中。
     */
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        if (list.head == null) {
            return; // Nothing to move
        }

        ListNode<E> current = list.head;
        while (current != null) {
            ListNode<E> nextNode = current.next; // Store next node
            removeListNode(current); // Remove from the source list
            addListNode(current); // Add to this list
            current = nextNode; // Move to the next node
        }
    }

    private void removeListNode(ListNode<E> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // Node is head
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // Node is tail
        }
        node.next = null; // Clear references
        node.prev = null;
    }

    private void addListNode(ListNode<E> node) {
        if (tail == null) {
            head = tail = node; // List was empty
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node; // Update tail
        }
    }
}