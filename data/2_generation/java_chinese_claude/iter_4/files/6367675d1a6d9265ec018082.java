import java.util.*;

public class Graph {
    private class Node {
        int id;
        boolean isVirtual;
        Node realNode;
        List<Edge> edges;
        
        Node(int id) {
            this.id = id;
            this.isVirtual = false;
            this.edges = new ArrayList<>();
        }
    }

    private class Edge {
        Node source;
        Node target;
        int weight;
        
        Edge(Node source, Node target) {
            this.source = source;
            this.target = target;
            this.weight = 1;
        }
    }

    private Node currentNode;
    private Node nextNode;
    
    public Edge edgeToNext() {
        if (currentNode == null || nextNode == null) {
            return null;
        }
        
        // Get real nodes if virtual
        Node realSource = currentNode.isVirtual ? currentNode.realNode : currentNode;
        Node realTarget = nextNode.isVirtual ? nextNode.realNode : nextNode;
        
        // Find edge between real nodes
        for (Edge edge : realSource.edges) {
            if (edge.target == realTarget) {
                return edge;
            }
        }
        
        // Create new edge if none exists
        Edge newEdge = new Edge(realSource, realTarget);
        realSource.edges.add(newEdge);
        return newEdge;
    }
}