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

    // If the node is the head of the list
    if (prev == null) {
        // Update the head to the next node
        // Assuming 'head' is a class-level variable representing the head of the list
        head = next;
    } else {
        // Otherwise, update the previous node's next pointer
        prev.next = next;
        node.prev = null; // Help with garbage collection
    }

    // If the node is the tail of the list
    if (next == null) {
        // Update the tail to the previous node
        // Assuming 'tail' is a class-level variable representing the tail of the list
        tail = prev;
    } else {
        // Otherwise, update the next node's previous pointer
        next.prev = prev;
        node.next = null; // Help with garbage collection
    }

    // Clear the element to help with garbage collection
    node.element = null;

    return true;
}