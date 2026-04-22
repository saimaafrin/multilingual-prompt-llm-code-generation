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
        
        public Node(int id, Node realNode) {
            this.id = id;
            this.isVirtual = true;
            this.realCounterpart = realNode;
        }
    }
    
    // Edge class to represent graph edges
    private class Edge {
        private Node source;
        private Node target;
        
        public Edge(Node source, Node target) {
            this.source = source;
            this.target = target;
        }
    }
    
    /**
     * Returns an edge connecting previously returned node with node, which will be returned next. 
     * If either of the mentioned nodes is virtual, the edge will be incident to its real counterpart.
     * @return an edge from the current node to the next node
     */
    public Edge edgeToNext() {
        if (nodes == null || nodes.isEmpty() || currentNodeIndex >= nodes.size() - 1) {
            return null;
        }
        
        Node currentNode = nodes.get(currentNodeIndex);
        Node nextNode = nodes.get(currentNodeIndex + 1);
        
        // If nodes are virtual, use their real counterparts
        Node sourceNode = currentNode.isVirtual ? currentNode.realCounterpart : currentNode;
        Node targetNode = nextNode.isVirtual ? nextNode.realCounterpart : nextNode;
        
        // Find edge connecting source to target
        for (Edge edge : edges) {
            if ((edge.source == sourceNode && edge.target == targetNode) ||
                (edge.source == targetNode && edge.target == sourceNode)) {
                return edge;
            }
        }
        
        return null;
    }
}