// Assuming the class is part of a larger structure where `prev` and `next` are references to the previous and next nodes in the doubly linked list.

public class Edge {
    Edge prev;
    Edge next;

    public void removeFromTreeEdgeList() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
        // Optionally, you can set this node's prev and next to null to help with garbage collection
        this.prev = null;
        this.next = null;
    }
}