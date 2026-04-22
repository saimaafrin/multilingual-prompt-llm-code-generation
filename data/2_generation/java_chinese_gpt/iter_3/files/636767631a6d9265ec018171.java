class ListNodeImpl<E> {
    E value;
    ListNodeImpl<E> next;

    ListNodeImpl(E value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * 从列表中移除非空的 {@code node}。
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null || head == null) {
            return false;
        }

        // If the node to unlink is the head
        if (node == head) {
            head = head.next;
            return true;
        }

        // Find the previous node
        ListNodeImpl<E> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }

        // If the node was not found
        if (current == null) {
            return false;
        }

        // Unlink the node
        current.next = node.next;
        return true;
    }
}