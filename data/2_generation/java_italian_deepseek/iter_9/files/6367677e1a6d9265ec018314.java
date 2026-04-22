import java.util.*;

class CategoryTree {
    private Node root;

    private class Node {
        String name;
        boolean active;
        List<Node> children;

        Node(String name) {
            this.name = name;
            this.active = true;
            this.children = new ArrayList<>();
        }
    }

    public CategoryTree() {
        this.root = new Node("Root");
    }

    protected int removeUnusedNodes() {
        return removeUnusedNodes(root);
    }

    private int removeUnusedNodes(Node node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;
        Iterator<Node> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            Node child = iterator.next();
            if (!child.active) {
                iterator.remove();
                removedCount++;
            } else {
                removedCount += removeUnusedNodes(child);
            }
        }

        return removedCount;
    }

    // Example usage
    public static void main(String[] args) {
        CategoryTree tree = new CategoryTree();
        // Add nodes and set some as inactive for testing
        // ...

        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed " + removedNodes + " unused nodes.");
    }
}