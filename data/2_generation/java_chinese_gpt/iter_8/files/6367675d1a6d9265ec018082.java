import java.util.Objects;

class Node {
    // Assuming Node class has some properties
    private boolean isVirtual;
    private String name;

    public Node(String name, boolean isVirtual) {
        this.name = name;
        this.isVirtual = isVirtual;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public String getName() {
        return name;
    }
}

class Edge {
    private Node from;
    private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge from " + from.getName() + " to " + to.getName();
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
        Node realCurrentNode = currentNode.isVirtual() ? getRealNode(currentNode) : currentNode;
        Node realNextNode = nextNode.isVirtual() ? getRealNode(nextNode) : nextNode;
        return new Edge(realCurrentNode, realNextNode);
    }

    private Node getRealNode(Node virtualNode) {
        // Logic to get the real node corresponding to the virtual node
        // For demonstration, we will just return a new Node with "Real" prefix
        return new Node("Real " + virtualNode.getName(), false);
    }
}

public class Main {
    public static void main(String[] args) {
        Node current = new Node("A", false);
        Node next = new Node("B", true);
        Graph graph = new Graph(current, next);
        Edge edge = graph.edgeToNext();
        System.out.println(edge);
    }
}