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

        int count = 0;
        Iterator<Node> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            Node child = iterator.next();
            if (!child.isActive) {
                iterator.remove();
                count++;
            } else {
                count += removeUnusedNodesHelper(child);
            }
        }

        return count;
    }

    // Example usage
    public static void main(String[] args) {
        CategoryTree tree = new CategoryTree();
        Node root = tree.root;
        root.children.add(new Node("Child1", true));
        root.children.add(new Node("Child2", false));
        root.children.get(0).children.add(new Node("Grandchild1", false));
        root.children.get(0).children.add(new Node("Grandchild2", true));

        int removedCount = tree.removeUnusedNodes();
        System.out.println("Removed " + removedCount + " unused nodes.");
    }
}