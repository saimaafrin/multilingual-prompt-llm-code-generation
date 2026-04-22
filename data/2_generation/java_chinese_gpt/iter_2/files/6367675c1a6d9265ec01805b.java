import java.util.LinkedList;

class TreeNode {
    int value;
    LinkedList<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new LinkedList<>();
    }
}

public class TreeEdgeList {
    private TreeNode root;

    public TreeEdgeList(TreeNode root) {
        this.root = root;
    }

    /**
     * 从树的双向链表中移除该边。
     */
    public void removeFromTreeEdgeList(TreeNode parent, TreeNode child) {
        if (parent == null || child == null) {
            return;
        }
        
        // Remove child from parent's children list
        parent.children.remove(child);
        
        // Optionally, if you want to remove the parent reference from child
        // child.parent = null; // Assuming you have a parent reference in TreeNode
    }
}