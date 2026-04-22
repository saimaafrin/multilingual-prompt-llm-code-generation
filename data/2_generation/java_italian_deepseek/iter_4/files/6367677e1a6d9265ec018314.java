import java.util.*;

class CategoryTree {
    private Node root;

    private class Node {
        String name;
        boolean active;
        List<Node> children;

        Node(String name, boolean active) {
            this.name = name;
            this.active = active;
            this.children = new ArrayList<>();
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
        // Populate the tree with nodes
        // tree.root = new Node("Root", true);
        // tree.root.children.add(new Node("Child1", false));
        // tree.root.children.add(new Node("Child2", true));
        // etc.

        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed " + removedNodes + " unused nodes.");
    }
}