import java.util.List;

public class TreeEdge {
    private TreeNode source;
    private TreeNode target;
    private TreeEdge nextOutgoing;
    private TreeEdge prevOutgoing;
    private TreeEdge nextIncoming; 
    private TreeEdge prevIncoming;

    /**
     * Removes this edge from both doubly linked lists of tree edges.
     */
    public void remove() {
        // Remove from outgoing edges list
        if (prevOutgoing != null) {
            prevOutgoing.nextOutgoing = nextOutgoing;
        } else {
            source.firstOutgoingEdge = nextOutgoing;
        }
        
        if (nextOutgoing != null) {
            nextOutgoing.prevOutgoing = prevOutgoing;
        }

        // Remove from incoming edges list 
        if (prevIncoming != null) {
            prevIncoming.nextIncoming = nextIncoming;
        } else {
            target.firstIncomingEdge = nextIncoming;
        }
        
        if (nextIncoming != null) {
            nextIncoming.prevIncoming = prevIncoming;
        }

        // Clear references
        nextOutgoing = null;
        prevOutgoing = null;
        nextIncoming = null;
        prevIncoming = null;
        source = null;
        target = null;
    }
}

class TreeNode {
    TreeEdge firstOutgoingEdge;
    TreeEdge firstIncomingEdge;
}