import java.util.LinkedList;

public class Edge {
    private Node source;
    private Node target;
    private LinkedList<Edge> treeEdgeList1;
    private LinkedList<Edge> treeEdgeList2;

    public Edge(Node source, Node target) {
        this.source = source;
        this.target = target;
    }

    /**
     * Elimina este borde de ambas listas doblemente enlazadas de bordes del árbol.
     */
    public void removeFromTreeEdgeList() {
        if (treeEdgeList1 != null) {
            treeEdgeList1.remove(this);
        }
        
        if (treeEdgeList2 != null) {
            treeEdgeList2.remove(this);
        }
    }
}

class Node {
    // Node implementation
}