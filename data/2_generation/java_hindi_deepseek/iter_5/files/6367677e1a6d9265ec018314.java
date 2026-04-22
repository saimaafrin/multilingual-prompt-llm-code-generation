import java.util.*;

class Node {
    int id;
    boolean active;
    List<Node> children;

    public Node(int id, boolean active) {
        this.id = id;
        this.active = active;
        this.children = new ArrayList<>();
    }
}

class Tree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    /**
     * श्रेणी वृक्ष से किसी भी निष्क्रिय नोड्स को हटा देता है।
     */
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