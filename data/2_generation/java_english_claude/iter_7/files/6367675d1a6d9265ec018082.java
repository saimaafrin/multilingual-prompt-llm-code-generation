import java.util.*;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;
    private int currentNodeIndex;
    
    // Node class to represent graph vertices
    private class Node {
        private int id;
        private boolean isVirtual;
        private Node realCounterpart;
        
        public Node(int id) {
            this.id = id;
            this.isVirtual = false;
            this.realCounterpart = null;
        }
    }
    
    // Edge class to represent graph edges
    private class Edge {
        private Node source;
        private Node destination;
        
        public Edge(Node source, Node destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    
    /**
     * Returns an edge connecting previously returned node with node, which will be returned next. 
     * If either of the mentioned nodes is virtual, the edge will be incident to its real counterpart.
     * @return an edge from the current node to the next node
     */
    public Edge edgeToNext() {
        if (currentNodeIndex >= nodes.size() - 1) {
            return null;
        }
        
        Node currentNode = nodes.get(currentNodeIndex);
        Node nextNode = nodes.get(currentNodeIndex + 1);
        
        // If nodes are virtual, use their real counterparts
        Node sourceNode = currentNode.isVirtual ? currentNode.realCounterpart : currentNode;
        Node destNode = nextNode.isVirtual ? nextNode.realCounterpart : nextNode;
        
        // Find the edge connecting these nodes
        for (Edge edge : edges) {
            if ((edge.source == sourceNode && edge.destination == destNode) ||
                (edge.source == destNode && edge.destination == sourceNode)) {
                return edge;
            }
        }
        
        return null;
    }
}