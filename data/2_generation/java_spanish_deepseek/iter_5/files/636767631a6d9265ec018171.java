// Assuming ListNodeImpl is a class defined as follows:
class ListNodeImpl<E> {
    E element;
    ListNodeImpl<E> next;
    ListNodeImpl<E> prev;

    ListNodeImpl(E element, ListNodeImpl<E> prev, ListNodeImpl<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}

private boolean unlink(ListNodeImpl<E> node) {
    if (node == null) {
        return false;
    }

    ListNodeImpl<E> prev = node.prev;
    ListNodeImpl<E> next = node.next;

    if (prev != null) {
        prev.next = next;
    } else {
        // If prev is null, it means node is the head of the list
        // You might need to update the head reference in your list class
    }

    if (next != null) {
        next.prev = prev;
    } else {
        // If next is null, it means node is the tail of the list
        // You might need to update the tail reference in your list class
    }

    // Clear the node's references to help with garbage collection
    node.element = null;
    node.next = null;
    node.prev = null;

    return true;
}