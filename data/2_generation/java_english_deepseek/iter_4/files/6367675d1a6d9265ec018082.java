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
}

class Node {
    private boolean isVirtual;

    public Node(boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public Node getRealCounterpart() {
        // Assuming that the real counterpart is always a non-virtual node
        return new Node(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return isVirtual == node.isVirtual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isVirtual);
    }
}

public class Graph {
    private Node currentNode;
    private Node nextNode;

    public Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    public Edge edgeToNext() {
        Node from = currentNode.isVirtual() ? currentNode.getRealCounterpart() : currentNode;
        Node to = nextNode.isVirtual() ? nextNode.getRealCounterpart() : nextNode;
        return new Edge(from, to);
    }
}