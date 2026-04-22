public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    Edge edge; // Assuming Edge is a class that represents an edge in the tree

    public void removeFromTreeEdgeList() {
        if (this.edge != null) {
            // Assuming Edge has a method to remove itself from the linked list
            this.edge.remove();
            this.edge = null; // Remove reference to the edge
        }
    }
}

class Edge {
    Edge next; // Next edge in the doubly linked list
    Edge prev; // Previous edge in the doubly linked list

    public void remove() {
        if (prev != null) {
            prev.next = next; // Bypass this edge in the list
        }
        if (next != null) {
            next.prev = prev; // Bypass this edge in the list
        }
        // Clear references
        this.next = null;
        this.prev = null;
    }
}