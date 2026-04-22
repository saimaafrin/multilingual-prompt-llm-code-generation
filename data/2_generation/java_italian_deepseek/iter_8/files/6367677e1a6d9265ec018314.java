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

    /**
     * Rimuove eventuali nodi inattivi dall'albero delle Categorie.
     * @return il numero di nodi rimossi.
     */
    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(Node node) {
        int count = 0;
        Iterator<Node> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            Node child = iterator.next();
            if (!child.active) {
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
        // Populate the tree with nodes and set some as inactive
        // tree.removeUnusedNodes();
    }
}