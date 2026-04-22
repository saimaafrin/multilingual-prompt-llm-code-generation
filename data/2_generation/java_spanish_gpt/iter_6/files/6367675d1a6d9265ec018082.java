import java.util.Optional;

class Node {
    private boolean isVirtual;
    private Node realNode;

    public Node(boolean isVirtual, Node realNode) {
        this.isVirtual = isVirtual;
        this.realNode = realNode;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public Node getRealNode() {
        return realNode;
    }
}

class Edge {
    private Node from;
    private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    // Additional methods can be added here
}

public class Graph {
    private Node currentNode;
    private Node nextNode;

    public Graph(Node currentNode, Node nextNode) {
        this.currentNode = currentNode;
        this.nextNode = nextNode;
    }

    /**
     * Devuelve una arista que conecta el nodo previamente devuelto con el nodo que se devolverá a continuación. 
     * Si alguno de los nodos mencionados es virtual, la arista será incidente a su contraparte real.
     * @return una arista desde el nodo actual hasta el siguiente nodo
     */
    public Edge edgeToNext() {
        Node fromNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node toNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;
        return new Edge(fromNode, toNode);
    }

    public static void main(String[] args) {
        Node realNode1 = new Node(false, null);
        Node virtualNode1 = new Node(true, realNode1);
        Node realNode2 = new Node(false, null);
        Graph graph = new Graph(virtualNode1, realNode2);
        Edge edge = graph.edgeToNext();
        // Further processing can be done with the edge
    }
}