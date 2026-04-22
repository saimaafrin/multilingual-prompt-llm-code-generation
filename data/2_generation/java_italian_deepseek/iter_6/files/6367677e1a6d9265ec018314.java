import java.util.*;

class CategoryTree {
    private Node root;

    private class Node {
        String name;
        List<Node> children;
        boolean active;

        Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.active = true;
        }
    }

    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(Node node) {
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
                removedCount += removeUnusedNodesHelper(child);
            }
        }

        return removedCount;
    }

    // Example usage
    public static void main(String[] args) {
        CategoryTree tree = new CategoryTree();
        // Populate the tree with nodes and set some as inactive
        // tree.removeUnusedNodes(); // Call to remove unused nodes
    }
}