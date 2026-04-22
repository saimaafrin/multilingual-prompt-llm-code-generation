import java.util.Objects;

class Edge {
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

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}

class Node {
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

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", isVirtual=" + isVirtual +
                '}';
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
        Node from = currentNode.isVirtual() ? getRealEquivalent(currentNode) : currentNode;
        Node to = nextNode.isVirtual() ? getRealEquivalent(nextNode) : nextNode;
        return new Edge(from, to);
    }

    private Node getRealEquivalent(Node node) {
        // Assuming that the real equivalent is a node with the same ID but not virtual
        return new Node(node.getId(), false);
    }
}