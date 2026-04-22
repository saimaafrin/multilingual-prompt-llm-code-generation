// Assuming ListNodeImpl is a class that represents a node in a linked list
// and it has the following structure:
// class ListNodeImpl<E> {
//     E data;
//     ListNodeImpl<E> next;
//     ListNodeImpl<E> prev;
// }

private boolean unlink(ListNodeImpl<E> node) {
    if (node == null) {
        return false;
    }

    // If the node has a previous node, update its next reference
    if (node.prev != null) {
        node.prev.next = node.next;
    }

    // If the node has a next node, update its previous reference
    if (node.next != null) {
        node.next.prev = node.prev;
    }

    // Clear the node's references to help with garbage collection
    node.prev = null;
    node.next = null;

    return true;
}