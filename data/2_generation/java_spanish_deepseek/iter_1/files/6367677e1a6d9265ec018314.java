import java.util.*;

class Category {
    // Assuming Category class has necessary fields and methods
    // For example, it might have a boolean field to indicate if it's active
    boolean isActive;

    public boolean isActive() {
        return isActive;
    }
}

class TreeNode {
    Category category;
    TreeNode left;
    TreeNode right;

    TreeNode(Category category) {
        this.category = category;
        this.left = null;
        this.right = null;
    }
}

public class CategoryTree {
    private TreeNode root;

    public CategoryTree(TreeNode root) {
        this.root = root;
    }

    protected int removeUnusedNodes() {
        int[] count = new int[1]; // To keep track of the number of nodes removed
        root = removeUnusedNodesHelper(root, count);
        return count[0];
    }

    private TreeNode removeUnusedNodesHelper(TreeNode node, int[] count) {
        if (node == null) {
            return null;
        }

        // Recursively process the left and right subtrees
        node.left = removeUnusedNodesHelper(node.left, count);
        node.right = removeUnusedNodesHelper(node.right, count);

        // If the current node's category is inactive, remove it
        if (!node.category.isActive()) {
            count[0]++;
            // If the node has no children, return null
            if (node.left == null && node.right == null) {
                return null;
            }
            // If the node has only one child, return that child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // If the node has two children, find the in-order successor (smallest in the right subtree)
            TreeNode successor = findMin(node.right);
            node.category = successor.category;
            node.right = removeUnusedNodesHelper(node.right, count);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Example usage
    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(new Category());
        root.left = new TreeNode(new Category());
        root.right = new TreeNode(new Category());
        root.left.left = new TreeNode(new Category());
        root.left.right = new TreeNode(new Category());

        // Assume some categories are inactive
        root.left.category.isActive = false;
        root.left.right.category.isActive = false;

        CategoryTree tree = new CategoryTree(root);
        int removedCount = tree.removeUnusedNodes();
        System.out.println("Number of nodes removed: " + removedCount);
    }
}