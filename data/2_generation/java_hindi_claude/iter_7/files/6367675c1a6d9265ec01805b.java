import java.util.List;

public class TreeEdge {
    private TreeEdge prev;
    private TreeEdge next;
    private TreeNode source;
    private TreeNode target;
    
    /**
     * Removes this edge from both doubly linked lists of tree edges.
     */
    public void remove() {
        // Handle previous edge's next pointer
        if (prev != null) {
            prev.next = next;
        }
        
        // Handle next edge's previous pointer
        if (next != null) {
            next.prev = prev;
        }
        
        // Remove references from source node
        if (source != null) {
            source.removeEdge(this);
        }
        
        // Remove references from target node 
        if (target != null) {
            target.removeEdge(this);
        }
        
        // Clear this edge's pointers
        prev = null;
        next = null;
        source = null;
        target = null;
    }
}

// Supporting class
class TreeNode {
    public void removeEdge(TreeEdge edge) {
        // Implementation for removing edge from node
    }
}