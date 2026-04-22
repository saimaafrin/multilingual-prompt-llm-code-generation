import java.util.Objects;

class Node {
    // Node class implementation
}

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

class Graph {
    private Node currentNode;
    private Node nextNode;

    public Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    public Edge edgeToNext() {
        // Assuming that if a node is virtual, it has a real counterpart
        Node realCurrent = currentNode.isVirtual() ? currentNode.getRealCounterpart() : currentNode;
        Node realNext = nextNode.isVirtual() ? nextNode.getRealCounterpart() : nextNode;

        return new Edge(realCurrent, realNext);
    }
}

// Assuming Node class has methods isVirtual() and getRealCounterpart()