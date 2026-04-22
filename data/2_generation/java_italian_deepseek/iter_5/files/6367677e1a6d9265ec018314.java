import java.util.*;

class CategoryTree {
    private static class Node {
        int id;
        List<Node> children;

        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
        }
    }

    private Node root;

    public CategoryTree(int rootId) {
        this.root = new Node(rootId);
    }

    /**
     * Rimuove eventuali nodi inattivi dall'albero delle Categorie.
     * Un nodo è considerato inattivo se non ha figli.
     * @return il numero di nodi rimossi.
     */
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
            count += removeUnusedNodesHelper(child);
            if (child.children.isEmpty()) {
                iterator.remove();
                count++;
            }
        }

        return count;
    }

    // Metodi di utilità per testare l'implementazione
    public void addChild(int parentId, int childId) {
        Node parent = findNode(root, parentId);
        if (parent != null) {
            parent.children.add(new Node(childId));
        }
    }

    private Node findNode(Node node, int id) {
        if (node == null) {
            return null;
        }
        if (node.id == id) {
            return node;
        }
        for (Node child : node.children) {
            Node found = findNode(child, id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CategoryTree tree = new CategoryTree(1);
        tree.addChild(1, 2);
        tree.addChild(1, 3);
        tree.addChild(2, 4);
        tree.addChild(3, 5);

        System.out.println("Nodi rimossi: " + tree.removeUnusedNodes());
    }
}