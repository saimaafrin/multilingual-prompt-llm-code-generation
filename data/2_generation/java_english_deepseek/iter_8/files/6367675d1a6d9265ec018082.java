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
    private Node realCounterpart;

    public Node(boolean isVirtual, Node realCounterpart) {
        this.isVirtual = isVirtual;
        this.realCounterpart = realCounterpart;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public Node getRealCounterpart() {
        return realCounterpart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return isVirtual == node.isVirtual && Objects.equals(realCounterpart, node.realCounterpart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isVirtual, realCounterpart);
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
        Node from = currentNode.isVirtual() ? currentNode.getRealCounterpart() : currentNode;
        Node to = nextNode.isVirtual() ? nextNode.getRealCounterpart() : nextNode;
        return new Edge(from, to);
    }
}