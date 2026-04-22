import java.util.LinkedList;

public class TreeEdge {
    private TreeEdge prevTreeEdge;
    private TreeEdge nextTreeEdge;
    private LinkedList<TreeEdge> firstList;
    private LinkedList<TreeEdge> secondList;

    /**
     * Removes this edge from both doubly linked lists of tree edges.
     */
    public void removeFromTreeEdgeList() {
        // Remove from first list
        if (prevTreeEdge != null) {
            prevTreeEdge.nextTreeEdge = nextTreeEdge;
        } else if (firstList != null) {
            firstList.removeFirst();
        }
        
        if (nextTreeEdge != null) {
            nextTreeEdge.prevTreeEdge = prevTreeEdge;
        } else if (firstList != null) {
            firstList.removeLast();
        }

        // Remove from second list
        if (secondList != null) {
            secondList.remove(this);
        }

        // Clear references
        prevTreeEdge = null;
        nextTreeEdge = null;
        firstList = null;
        secondList = null;
    }
}