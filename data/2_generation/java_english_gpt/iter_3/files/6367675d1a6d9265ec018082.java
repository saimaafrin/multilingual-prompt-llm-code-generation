import java.util.Objects;

class Node {
    private final boolean isVirtual;
    private final Node realNode;

    public Node(boolean isVirtual, Node realNode) {
        this.isVirtual = isVirtual;
        this.realNode = realNode;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public Node getRealNode() {
        return isVirtual ? realNode : this;
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
     * Returns an edge connecting previously returned node with node, which will be returned next. If either of the mentioned nodes is virtual, the edge will be incident to its real counterpart.
     * @return an edge from the current node to the next node
     */
    public Edge edgeToNext() {
        Node fromNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node toNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;
        return new Edge(fromNode, toNode);
    }
}