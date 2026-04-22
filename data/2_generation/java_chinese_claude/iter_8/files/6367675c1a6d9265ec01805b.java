import java.util.LinkedList;

public class TreeEdge {
    private TreeNode source;
    private TreeNode target;
    private LinkedList<TreeEdge> sourceEdges;
    private LinkedList<TreeEdge> targetEdges;

    /**
     * 从树的双向链表中移除该边。
     */
    public void removeFromTreeEdgeList() {
        if (sourceEdges != null) {
            sourceEdges.remove(this);
        }
        if (targetEdges != null) {
            targetEdges.remove(this);
        }
        source = null;
        target = null;
        sourceEdges = null;
        targetEdges = null;
    }
}