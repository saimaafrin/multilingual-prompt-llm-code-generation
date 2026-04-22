import java.util.*;

class CategoryTree {
    private static class Node {
        int id;
        boolean active;
        List<Node> children;

        Node(int id, boolean active) {
            this.id = id;
            this.active = active;
            this.children = new ArrayList<>();
        }
    }

    private Node root;

    public CategoryTree(Node root) {
        this.root = root;
    }

    /**
     * Rimuove eventuali nodi inattivi dall'albero delle Categorie.
     * @return Il numero di nodi rimossi.
     */
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

    public static void main(String[] args) {
        Node root = new Node(1, true);
        Node child1 = new Node(2, false);
        Node child2 = new Node(3, true);
        Node child3 = new Node(4, false);
        Node child4 = new Node(5, true);

        root.children.add(child1);
        root.children.add(child2);
        child2.children.add(child3);
        child2.children.add(child4);

        CategoryTree tree = new CategoryTree(root);
        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Nodi rimossi: " + removedNodes);
    }
}