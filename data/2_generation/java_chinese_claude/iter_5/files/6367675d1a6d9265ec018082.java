import java.util.*;

class Graph {
    private class Node {
        int id;
        List<Edge> edges;
        Node virtualNode; // Real node if this is virtual

        Node(int id) {
            this.id = id;
            this.edges = new ArrayList<>();
        }
    }

    private class Edge {
        Node source;
        Node target;
        int weight;

        Edge(Node source, Node target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    private Node currentNode;
    private Node nextNode;
    private Map<Node, Node> virtualToReal;

    public Edge edgeToNext() {
        if (currentNode == null || nextNode == null) {
            return null;
        }

        // Get real nodes if virtual
        Node realCurrent = currentNode.virtualNode != null ? 
                          currentNode.virtualNode : currentNode;
        Node realNext = nextNode.virtualNode != null ?
                       nextNode.virtualNode : nextNode;

        // Find edge between real nodes
        for (Edge edge : realCurrent.edges) {
            if (edge.target == realNext) {
                return edge;
            }
        }

        return null;
    }
}