import java.util.ArrayList;
import java.util.List;

class Node {
    boolean isActive;
    List<Node> children;

    Node(boolean isActive) {
        this.isActive = isActive;
        this.children = new ArrayList<>();
    }
}

public class CategoryTree {
    private Node root;

    public CategoryTree(Node root) {
        this.root = root;
    }

    /** 
     * 从类别树中移除所有不活跃的节点。
     */
    protected int removeUnusedNodes() {
        return removeUnusedNodes(root);
    }

    private int removeUnusedNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;

        // Recursively remove unused nodes from children
        List<Node> activeChildren = new ArrayList<>();
        for (Node child : node.children) {
            int count = removeUnusedNodes(child);
            removedCount += count;
            if (child.isActive || count == 0) {
                activeChildren.add(child);
            }
        }

        node.children = activeChildren;

        // If the current node is not active and has no active children, it should be removed
        if (!node.isActive && activeChildren.isEmpty()) {
            removedCount++;
            return removedCount; // This node is considered removed
        }

        return removedCount; // This node is kept
    }
}