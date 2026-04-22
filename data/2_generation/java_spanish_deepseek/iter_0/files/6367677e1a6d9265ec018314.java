import java.util.*;

class Category {
    // Assuming Category class has necessary fields and methods
    // For example, a field to check if the node is active
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

class TreeNode {
    Category category;
    List<TreeNode> children;

    public TreeNode(Category category) {
        this.category = category;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public Category getCategory() {
        return category;
    }
}

public class Tree {
    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    /**
     * Elimina cualquier nodo inactivo del árbol con elementos de tipo "Category".
     */
    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;
        List<TreeNode> children = node.getChildren();
        Iterator<TreeNode> iterator = children.iterator();

        while (iterator.hasNext()) {
            TreeNode child = iterator.next();
            if (!child.getCategory().isActive()) {
                iterator.remove();
                removedCount++;
            } else {
                removedCount += removeUnusedNodesHelper(child);
            }
        }

        return removedCount;
    }

    public static void main(String[] args) {
        // Example usage
        Category rootCategory = new Category();
        rootCategory.setActive(true);

        TreeNode rootNode = new TreeNode(rootCategory);
        Tree tree = new Tree(rootNode);

        Category childCategory1 = new Category();
        childCategory1.setActive(false);
        TreeNode childNode1 = new TreeNode(childCategory1);
        rootNode.addChild(childNode1);

        Category childCategory2 = new Category();
        childCategory2.setActive(true);
        TreeNode childNode2 = new TreeNode(childCategory2);
        rootNode.addChild(childNode2);

        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed " + removedNodes + " unused nodes.");
    }
}