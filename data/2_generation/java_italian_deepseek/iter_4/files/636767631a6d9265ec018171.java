// Assuming ListNodeImpl is a class defined as follows:
class ListNodeImpl<E> {
    E data;
    ListNodeImpl<E> next;
    ListNodeImpl<E> prev;

    ListNodeImpl(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

private boolean unlink(ListNodeImpl<E> node) {
    if (node == null) {
        return false;
    }

    ListNodeImpl<E> prevNode = node.prev;
    ListNodeImpl<E> nextNode = node.next;

    if (prevNode != null) {
        prevNode.next = nextNode;
    }

    if (nextNode != null) {
        nextNode.prev = prevNode;
    }

    // Clear the node's references to help with garbage collection
    node.prev = null;
    node.next = null;

    return true;
}