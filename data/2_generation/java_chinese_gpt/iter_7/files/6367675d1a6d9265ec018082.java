import java.util.Objects;

class Node {
    // Assume Node class has necessary properties and methods
}

class Edge {
    private Node from;
    private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
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
        // Logic to determine if the node is virtual and return the real node
        // For simplicity, we will assume the node is already real in this example
        return Objects.requireNonNull(node, "Node cannot be null");
    }
}