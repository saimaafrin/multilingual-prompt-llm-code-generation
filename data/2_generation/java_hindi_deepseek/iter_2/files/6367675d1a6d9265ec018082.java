import java.util.*;

class Edge {
    Node from;
    Node to;

    Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }
}

class Node {
    int id;
    boolean isVirtual;

    Node(int id, boolean isVirtual) {
        this.id = id;
        this.isVirtual = isVirtual;
    }

    Node getRealEquivalent() {
        if (this.isVirtual) {
            // Assuming a mapping or logic to get the real equivalent
            return new Node(this.id, false); // Replace with actual logic
        }
        return this;
    }
}

class Graph {
    Node currentNode;
    Node nextNode;

    Edge edgeToNext() {
        Node realFrom = currentNode.getRealEquivalent();
        Node realTo = nextNode.getRealEquivalent();
        return new Edge(realFrom, realTo);
    }
}