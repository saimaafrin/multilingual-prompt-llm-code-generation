import java.util.LinkedList;

public class TreeEdge {
    private LinkedList<TreeEdge> treeEdgeList;
    
    /**
     * 从树的双向链表中移除该边。
     */
    public void removeFromTreeEdgeList() {
        if (treeEdgeList != null) {
            treeEdgeList.remove(this);
            treeEdgeList = null;
        }
    }
}