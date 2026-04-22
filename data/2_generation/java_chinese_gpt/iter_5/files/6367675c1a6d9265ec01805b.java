import java.util.LinkedList;

class TreeEdge {
    TreeEdge next;
    TreeEdge prev;
    // Other properties of the edge can be added here
}

class TreeEdgeList {
    private LinkedList<TreeEdge> edges;

    public TreeEdgeList() {
        edges = new LinkedList<>();
    }

    /**
     * 从树的双向链表中移除该边。
     */
    public void removeFromTreeEdgeList(TreeEdge edge) {
        if (edge == null) {
            return; // Edge to remove is null
        }
        if (edges.contains(edge)) {
            edges.remove(edge);
            // Update the next and prev pointers if necessary
            if (edge.prev != null) {
                edge.prev.next = edge.next;
            }
            if (edge.next != null) {
                edge.next.prev = edge.prev;
            }
            edge.prev = null; // Clear references
            edge.next = null; // Clear references
        }
    }
}