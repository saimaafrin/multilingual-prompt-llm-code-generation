import java.util.*;

class CategoryTree {
    private Node root;

    private class Node {
        String name;
        boolean isActive;
        List<Node> children;

        Node(String name, boolean isActive) {
            this.name = name;
            this.isActive = isActive;
            this.children = new ArrayList<>();
        }
    }

    public CategoryTree() {
        this.root = new Node("Root", true);
    }

    protected int removeUnusedNodes() {
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
            if (!child.isActive) {
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
        Node root = tree.root;
        root.children.add(new Node("Child1", false));
        root.children.add(new Node("Child2", true));
        root.children.get(1).children.add(new Node("Grandchild1", false));

        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed " + removedNodes + " unused nodes.");
    }
}