import java.util.LinkedList;

public class TreeEdge {
    private TreeEdge prevTreeEdge;
    private TreeEdge nextTreeEdge;
    private LinkedList<TreeEdge> sourceEdges;
    private LinkedList<TreeEdge> targetEdges;
    
    /**
     * Removes this edge from both doubly linked lists of tree edges.
     */
    public void removeFromTreeEdgeList() {
        // Remove from source edges list
        if (sourceEdges != null) {
            sourceEdges.remove(this);
        }
        
        // Remove from target edges list
        if (targetEdges != null) {
            targetEdges.remove(this);
        }
        
        // Update previous edge's next pointer
        if (prevTreeEdge != null) {
            prevTreeEdge.nextTreeEdge = nextTreeEdge;
        }
        
        // Update next edge's previous pointer
        if (nextTreeEdge != null) {
            nextTreeEdge.prevTreeEdge = prevTreeEdge;
        }
        
        // Clear this edge's pointers
        prevTreeEdge = null;
        nextTreeEdge = null;
    }
}