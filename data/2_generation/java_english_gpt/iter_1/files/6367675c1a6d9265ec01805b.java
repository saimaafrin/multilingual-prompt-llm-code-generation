public void removeFromTreeEdgeList() {
    // Assuming there are two doubly linked lists for tree edges
    // and this edge is represented by 'this'.
    
    // Pointers to the previous and next edges in the list
    Edge previousEdge = this.previous; // Assuming 'previous' is a reference to the previous edge
    Edge nextEdge = this.next; // Assuming 'next' is a reference to the next edge

    // Remove this edge from the previous edge's next reference
    if (previousEdge != null) {
        previousEdge.next = nextEdge;
    }

    // Remove this edge from the next edge's previous reference
    if (nextEdge != null) {
        nextEdge.previous = previousEdge;
    }

    // Clear the references of this edge
    this.previous = null;
    this.next = null;
}