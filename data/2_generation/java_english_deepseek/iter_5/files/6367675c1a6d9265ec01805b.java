public class Edge {
    private Edge prevTreeEdge;
    private Edge nextTreeEdge;

    /**
     * Removes this edge from both doubly linked lists of tree edges.
     */
    public void removeFromTreeEdgeList() {
        if (prevTreeEdge != null) {
            prevTreeEdge.nextTreeEdge = nextTreeEdge;
        }
        if (nextTreeEdge != null) {
            nextTreeEdge.prevTreeEdge = prevTreeEdge;
        }
        prevTreeEdge = null;
        nextTreeEdge = null;
    }
}