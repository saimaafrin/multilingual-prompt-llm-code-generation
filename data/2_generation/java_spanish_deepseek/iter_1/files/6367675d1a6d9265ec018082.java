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
    private String id;
    private boolean isVirtual;

    public Node(String id, boolean isVirtual) {
        this.id = id;
        this.isVirtual = isVirtual;
    }

    public String getId() {
        return id;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public Node getRealNode() {
        if (isVirtual) {
            // Assuming a virtual node has a real counterpart with the same ID but without the "virtual" flag
            return new Node(id, false);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return isVirtual == node.isVirtual && Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isVirtual);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
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
        Node fromNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node toNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;
        return new Edge(fromNode, toNode);
    }
}