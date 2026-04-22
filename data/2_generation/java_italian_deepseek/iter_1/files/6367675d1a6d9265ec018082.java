import java.util.Objects;

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
    public String toString() {
        return "Edge{" +
                "from=" + from.getId() +
                ", to=" + to.getId() +
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
        Node from = currentNode.isVirtual() ? getRealNode(currentNode) : currentNode;
        Node to = nextNode.isVirtual() ? getRealNode(nextNode) : nextNode;
        return new Edge(from, to);
    }

    private Node getRealNode(Node node) {
        // Assuming that the real node has the same ID but is not virtual
        return new Node(node.getId(), false);
    }
}

public class Main {
    public static void main(String[] args) {
        Node currentNode = new Node(1, true);
        Node nextNode = new Node(2, false);
        Graph graph = new Graph(currentNode, nextNode);
        Edge edge = graph.edgeToNext();
        System.out.println(edge);
    }
}