import java.util.LinkedList;

public class TreeEdge {
    private LinkedList<TreeEdge> horizontalEdges;
    private LinkedList<TreeEdge> verticalEdges;
    
    /**
     * Removes this edge from both doubly linked lists of tree edges.
     */
    public void remove() {
        if (horizontalEdges != null) {
            horizontalEdges.remove(this);
        }
        
        if (verticalEdges != null) {
            verticalEdges.remove(this);
        }
    }
}