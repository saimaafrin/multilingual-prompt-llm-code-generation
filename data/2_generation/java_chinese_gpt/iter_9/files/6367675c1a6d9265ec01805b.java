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
        if (parent.children.contains(child)) {
            parent.children.remove(child);
        }
        // Assuming it's a bidirectional edge, we also need to remove the parent reference from the child
        if (child.children.contains(parent)) {
            child.children.remove(parent);
        }
    }
}