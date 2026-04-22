public void removeFromTreeEdgeList() {
    // Assuming there are two doubly linked lists for edges: leftEdgeList and rightEdgeList
    // and that this method is part of a class that has access to these lists.

    // Remove this edge from the left edge list
    if (leftEdgeList != null) {
        if (leftEdgeList.prev != null) {
            leftEdgeList.prev.next = leftEdgeList.next;
        }
        if (leftEdgeList.next != null) {
            leftEdgeList.next.prev = leftEdgeList.prev;
        }
        leftEdgeList = null; // Clear reference to help with garbage collection
    }

    // Remove this edge from the right edge list
    if (rightEdgeList != null) {
        if (rightEdgeList.prev != null) {
            rightEdgeList.prev.next = rightEdgeList.next;
        }
        if (rightEdgeList.next != null) {
            rightEdgeList.next.prev = rightEdgeList.prev;
        }
        rightEdgeList = null; // Clear reference to help with garbage collection
    }
}