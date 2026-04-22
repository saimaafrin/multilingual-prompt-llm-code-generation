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
    boolean isVirtual;
    Node realNode;

    Node(boolean isVirtual, Node realNode) {
        this.isVirtual = isVirtual;
        this.realNode = realNode;
    }

    Node getRealNode() {
        return isVirtual ? realNode : this;
    }
}

class Graph {
    Node currentNode;
    Node nextNode;

    Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    Edge edgeToNext() {
        Node realFrom = currentNode.getRealNode();
        Node realTo = nextNode.getRealNode();
        return new Edge(realFrom, realTo);
    }
}