import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int value;
    Set<TreeNode> children;

    TreeNode(int value) {
        this.value = value;
        this.children = new HashSet<>();
    }

    void addChild(TreeNode child) {
        children.add(child);
    }
}

public class Tree {
    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    /** 
     * श्रेणी वृक्ष से किसी भी निष्क्रिय नोड्स को हटा देता है।
     */
    protected int removeUnusedNodes() {
        return removeUnusedNodes(root);
    }

    private int removeUnusedNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;

        // Recursively remove unused nodes from children
        Set<TreeNode> toRemove = new HashSet<>();
        for (TreeNode child : node.children) {
            removedCount += removeUnusedNodes(child);
            if (child.children.isEmpty()) {
                toRemove.add(child);
            }
        }

        // Remove unused children
        node.children.removeAll(toRemove);
        removedCount += toRemove.size();

        return removedCount;
    }
}