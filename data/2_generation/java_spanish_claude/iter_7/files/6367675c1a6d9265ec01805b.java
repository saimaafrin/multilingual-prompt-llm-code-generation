import java.util.LinkedList;

public class Edge {
    private Node source;
    private Node target;
    private LinkedList<Edge> treeEdgeList1;
    private LinkedList<Edge> treeEdgeList2;

    public void removeFromTreeEdgeList() {
        if (treeEdgeList1 != null) {
            treeEdgeList1.remove(this);
        }
        
        if (treeEdgeList2 != null) {
            treeEdgeList2.remove(this);
        }
    }
}