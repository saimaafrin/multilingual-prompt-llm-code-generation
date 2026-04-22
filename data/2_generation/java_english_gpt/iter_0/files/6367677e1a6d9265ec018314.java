import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class CategoryNode {
    boolean isActive;
    List<CategoryNode> children;

    public CategoryNode(boolean isActive) {
        this.isActive = isActive;
        this.children = new ArrayList<>();
    }

    public void addChild(CategoryNode child) {
        children.add(child);
    }
}

public class CategoryTree {
    private CategoryNode root;

    public CategoryTree(CategoryNode root) {
        this.root = root;
    }

    /** 
     * Removes any inactive nodes from the Category tree.
     */
    protected int removeUnusedNodes() {
        return removeInactiveNodes(root);
    }

    private int removeInactiveNodes(CategoryNode node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;

        // Iterate through children and remove inactive nodes
        Iterator<CategoryNode> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            CategoryNode child = iterator.next();
            removedCount += removeInactiveNodes(child);
            if (!child.isActive) {
                iterator.remove();
                removedCount++;
            }
        }

        return removedCount;
    }

    public static void main(String[] args) {
        // Example usage
        CategoryNode root = new CategoryNode(true);
        CategoryNode child1 = new CategoryNode(false);
        CategoryNode child2 = new CategoryNode(true);
        CategoryNode grandChild1 = new CategoryNode(false);
        
        root.addChild(child1);
        root.addChild(child2);
        child2.addChild(grandChild1);

        CategoryTree tree = new CategoryTree(root);
        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed nodes: " + removedNodes);
    }
}