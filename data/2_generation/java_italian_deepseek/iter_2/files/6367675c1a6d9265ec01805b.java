public class Edge {
    private Edge prevInTree;
    private Edge nextInTree;

    public void removeFromTreeEdgeList() {
        if (prevInTree != null) {
            prevInTree.nextInTree = nextInTree;
        }
        if (nextInTree != null) {
            nextInTree.prevInTree = prevInTree;
        }
        prevInTree = null;
        nextInTree = null;
    }
}