import java.util.Objects;

class Node {
    private final boolean isVirtual;

    public Node(boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public boolean isVirtual() {
        return isVirtual;
    }
}

class Edge {
    private final Node from;
    private final Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }
}

class Graph {
    private Node currentNode;
    private Node nextNode;

    public Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    /**
     * एक किनारे लौटाता है जो पहले लौटाए गए नोड को अगले लौटाए जाने वाले नोड से जोड़ता है। यदि इनमें से कोई भी नोड आभासी है, तो किनारा इसके वास्तविक समकक्ष पर होगा।
     * @return वर्तमान नोड से अगले नोड तक एक किनारा
     */
    public Edge edgeToNext() {
        Node realFrom = currentNode.isVirtual() ? getRealNode(currentNode) : currentNode;
        Node realTo = nextNode.isVirtual() ? getRealNode(nextNode) : nextNode;
        return new Edge(realFrom, realTo);
    }

    private Node getRealNode(Node virtualNode) {
        // Placeholder for logic to get the real node corresponding to a virtual node
        // This should be replaced with actual implementation
        return new Node(false); // Assuming a new real node is created for demonstration
    }
}