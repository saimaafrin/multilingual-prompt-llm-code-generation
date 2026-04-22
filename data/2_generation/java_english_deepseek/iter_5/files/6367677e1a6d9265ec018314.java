import java.util.*;

class CategoryNode {
    int id;
    boolean active;
    List<CategoryNode> children;

    public CategoryNode(int id, boolean active) {
        this.id = id;
        this.active = active;
        this.children = new ArrayList<>();
    }
}

public class CategoryTree {
    private CategoryNode root;

    public CategoryTree(CategoryNode root) {
        this.root = root;
    }

    /**
     * Removes any inactive nodes from the Category tree.
     * @return The number of nodes removed.
     */
    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(CategoryNode node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;
        Iterator<CategoryNode> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            CategoryNode child = iterator.next();
            if (!child.active) {
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
        CategoryNode root = new CategoryNode(1, true);
        CategoryNode child1 = new CategoryNode(2, false);
        CategoryNode child2 = new CategoryNode(3, true);
        CategoryNode child3 = new CategoryNode(4, false);

        root.children.add(child1);
        root.children.add(child2);
        child2.children.add(child3);

        CategoryTree tree = new CategoryTree(root);
        int removedCount = tree.removeUnusedNodes();
        System.out.println("Number of nodes removed: " + removedCount);
    }
}