import java.util.*;

public class Graph {
    private Map<Node, List<Edge>> adjacencyList;
    private Iterator<Node> nodeIterator;
    private Node currentNode;
    
    public Edge nextEdge() {
        if (currentNode == null || !nodeIterator.hasNext()) {
            return null;
        }
        
        Node nextNode = nodeIterator.next();
        
        // Get real nodes if virtual
        Node realCurrent = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node realNext = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;
        
        // Find edge between current and next nodes
        List<Edge> edges = adjacencyList.get(realCurrent);
        for (Edge edge : edges) {
            if (edge.connects(realCurrent, realNext)) {
                currentNode = nextNode;
                return edge;
            }
        }
        
        currentNode = nextNode;
        return null;
    }
    
    // Supporting classes
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