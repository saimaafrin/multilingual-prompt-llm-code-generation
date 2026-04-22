import java.util.Objects;

class Edge {
    private final Node from;
    private final Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    // Getters and other methods can be added here
}

class Node {
    private final String name;

    public Node(String name) {
        this.name = name;
    }

    // Getters and other methods can be added here
}

class Graph {
    private Node currentNode;
    private Node nextNode;

    public Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    /**
     * 返回一个连接之前返回的节点与下一个将要返回的节点之间的边。如果提到的任一节点是虚拟的，则该边将与其真实对应节点相连。
     * @return 从当前节点到下一个节点的边
     */
    public Edge edgeToNext() {
        Node realCurrentNode = getRealNode(currentNode);
        Node realNextNode = getRealNode(nextNode);
        return new Edge(realCurrentNode, realNextNode);
    }

    private Node getRealNode(Node node) {
        // Assuming some logic to determine if a node is virtual
        // For simplicity, we return the node itself
        return node;
    }
}