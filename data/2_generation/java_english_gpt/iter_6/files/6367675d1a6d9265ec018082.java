import java.util.Objects;

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

class Node {
    private final String name;
    private final boolean isVirtual;

    public Node(String name, boolean isVirtual) {
        this.name = name;
        this.isVirtual = isVirtual;
    }

    public String getName() {
        return name;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public Node getRealNode() {
        // Assuming the real counterpart is the same node without the virtual flag
        return new Node(name, false);
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
     * Returns an edge connecting previously returned node with node, which will be returned next. If either of the mentioned nodes is virtual, the edge will be incident to its real counterpart.
     * @return an edge from the current node to the next node
     */
    public Edge edgeToNext() {
        Node fromNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node toNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;
        return new Edge(fromNode, toNode);
    }
}