public class Edge {
    private Edge prevTreeEdge;
    private Edge nextTreeEdge;

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