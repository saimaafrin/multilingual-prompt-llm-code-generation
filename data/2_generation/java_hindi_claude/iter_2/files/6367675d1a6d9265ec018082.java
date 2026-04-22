import java.util.*;

public class Graph {
    private Map<Node, List<Edge>> adjacencyList;
    private Iterator<Node> nodeIterator;
    private Node currentNode;
    
    public Edge nextEdge() {
        // Get the current node if not already set
        if (currentNode == null && nodeIterator.hasNext()) {
            currentNode = nodeIterator.next();
        }
        
        // Get the next node
        Node nextNode = nodeIterator.hasNext() ? nodeIterator.next() : null;
        
        if (currentNode == null || nextNode == null) {
            return null;
        }
        
        // Handle virtual nodes by getting their real counterparts
        Node realCurrentNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node realNextNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;
        
        // Find edge between current and next node
        for (Edge edge : adjacencyList.get(realCurrentNode)) {
            if (edge.connects(realCurrentNode, realNextNode)) {
                // Update current node for next call
                currentNode = nextNode;
                return edge;
            }
        }
        
        // Update current node even if no edge found
        currentNode = nextNode;
        return null;
    }
    
    // Helper classes
    private class Node {
        private boolean virtual;
        private Node realNode;
        
        public boolean isVirtual() {
            return virtual;
        }
        
        public Node getRealNode() {
            return realNode;
        }
    }
    
    private class Edge {
        private Node source;
        private Node target;
        
        public boolean connects(Node n1, Node n2) {
            return (source == n1 && target == n2) || (source == n2 && target == n1);
        }
    }
}