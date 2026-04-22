// Assuming ListNodeImpl is a class defined elsewhere in your codebase
// Here is a basic implementation of the ListNodeImpl class for context
class ListNodeImpl<E> {
    E data;
    ListNodeImpl<E> next;

    ListNodeImpl(E data) {
        this.data = data;
        this.next = null;
    }
}

// The implementation of the unlink method
private boolean unlink(ListNodeImpl<E> node) {
    if (node == null) {
        return false; // Cannot unlink a null node
    }

    // If the node to be unlinked is the head of the list
    if (this.head == node) {
        this.head = node.next;
        if (this.head != null) {
            this.head.prev = null; // Assuming it's a doubly linked list
        }
        return true;
    }

    // Traverse the list to find the node
    ListNodeImpl<E> current = this.head;
    while (current != null && current.next != node) {
        current = current.next;
    }

    // If the node was found, unlink it
    if (current != null) {
        current.next = node.next;
        if (node.next != null) {
            node.next.prev = current; // Assuming it's a doubly linked list
        }
        return true;
    }

    return false; // Node not found in the list
}