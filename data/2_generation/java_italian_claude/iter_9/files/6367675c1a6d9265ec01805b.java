import java.util.LinkedList;

public class TreeEdge {
    private TreeEdge prev;
    private TreeEdge next;
    private LinkedList<TreeEdge> edgeList;

    /**
     * Rimuove questo arco da entrambe le liste doppiamente collegate degli archi dell'albero.
     */
    public void removeFromTreeEdgeList() {
        if (prev != null) {
            prev.next = next;
        }
        
        if (next != null) {
            next.prev = prev;
        }
        
        if (edgeList != null && edgeList.contains(this)) {
            edgeList.remove(this);
        }
        
        // Reset references
        prev = null;
        next = null;
        edgeList = null;
    }
}