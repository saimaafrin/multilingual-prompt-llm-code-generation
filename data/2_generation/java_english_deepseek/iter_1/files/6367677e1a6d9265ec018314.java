import java.util.*;

class CategoryNode {
    String name;
    boolean active;
    List<CategoryNode> children;

    CategoryNode(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.children = new ArrayList<>();
    }

    void addChild(CategoryNode child) {
        this.children.add(child);
    }
}

class CategoryTree {
    private CategoryNode root;

    CategoryTree(CategoryNode root) {
        this.root = root;
    }

    protected int removeUnusedNodes() {
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
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        CategoryNode root = new CategoryNode("Root", true);
        CategoryNode child1 = new CategoryNode("Child1", false);
        CategoryNode child2 = new CategoryNode("Child2", true);
        CategoryNode grandChild1 = new CategoryNode("GrandChild1", false);

        root.addChild(child1);
        root.addChild(child2);
        child2.addChild(grandChild1);

        CategoryTree tree = new CategoryTree(root);
        int removedCount = tree.removeUnusedNodes();
        System.out.println("Removed " + removedCount + " inactive nodes.");
    }
}