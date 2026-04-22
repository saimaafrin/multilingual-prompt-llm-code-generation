import java.util.Objects;

class Edge {
    private final Node from;
    private final Node to;

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
}

class Node {
    private final String name;
    private final boolean isVirtual;

    public Node(String name, boolean isVirtual) {
        this.name = name;
        this.isVirtual = isVirtual;
    }

    public String getName() {
        return name;
    }

    public boolean isVirtual() {
        return isVirtual;
    }
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
        Node fromNode = currentNode.isVirtual() ? getRealNode(currentNode) : currentNode;
        Node toNode = nextNode.isVirtual() ? getRealNode(nextNode) : nextNode;
        return new Edge(fromNode, toNode);
    }

    private Node getRealNode(Node virtualNode) {
        // This method should return the real corresponding node for a virtual node.
        // For demonstration purposes, we will return a new Node with the same name but not virtual.
        return new Node(virtualNode.getName(), false);
    }
}