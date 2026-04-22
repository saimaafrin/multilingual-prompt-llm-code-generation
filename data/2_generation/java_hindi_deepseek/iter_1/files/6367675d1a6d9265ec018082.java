import java.util.Objects;

class Node {
    // Node class implementation
    private int id;
    private boolean isVirtual;

    public Node(int id, boolean isVirtual) {
        this.id = id;
        this.isVirtual = isVirtual;
    }

    public int getId() {
        return id;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id && isVirtual == node.isVirtual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isVirtual);
    }
}

class Edge {
    // Edge class implementation
    private Node from;
    private Node to;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}

class Graph {
    private Node currentNode;
    private Node nextNode;

    public Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    public Edge edgeToNext() {
        Node from = currentNode.isVirtual() ? getRealNode(currentNode) : currentNode;
        Node to = nextNode.isVirtual() ? getRealNode(nextNode) : nextNode;
        return new Edge(from, to);
    }

    private Node getRealNode(Node node) {
        // Assuming that the real node has the same ID but is not virtual
        return new Node(node.getId(), false);
    }
}