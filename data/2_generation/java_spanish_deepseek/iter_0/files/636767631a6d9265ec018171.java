// Assuming ListNodeImpl is a class that represents a node in a linked list
// and it has the following structure:
// class ListNodeImpl<E> {
//     E element;
//     ListNodeImpl<E> next;
//     ListNodeImpl<E> prev;
// }

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
        // You might need to update the head reference in the list class
        // For example: list.head = next;
    }

    if (next != null) {
        next.prev = prev;
    } else {
        // If next is null, it means node is the tail of the list
        // You might need to update the tail reference in the list class
        // For example: list.tail = prev;
    }

    // Clear the node's references to help with garbage collection
    node.prev = null;
    node.next = null;

    return true;
}