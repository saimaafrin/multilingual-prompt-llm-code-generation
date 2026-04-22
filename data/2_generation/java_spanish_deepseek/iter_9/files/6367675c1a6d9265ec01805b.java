// Assuming the class has access to the doubly linked list of edges
// and the edge to be removed is the current edge (this).

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
        // Optionally, you can set this.prev and this.next to null to help with garbage collection
        this.prev = null;
        this.next = null;
    }
}