import java.util.*;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;
    private Node currentNode;
    private Iterator<Node> nodeIterator;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        nodeIterator = nodes.iterator();
    }

    public Edge edgeToNext() {
        if (currentNode == null || !nodeIterator.hasNext()) {
            return null;
        }

        Node nextNode = nodeIterator.next();
        
        // If current node is virtual, get its real counterpart
        Node realCurrentNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        
        // If next node is virtual, get its real counterpart
        Node realNextNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;

        // Find edge connecting the real nodes
        for (Edge edge : edges) {
            if ((edge.getSource() == realCurrentNode && edge.getTarget() == realNextNode) ||
                (edge.getSource() == realNextNode && edge.getTarget() == realCurrentNode)) {
                currentNode = nextNode;
                return edge;
            }
        }

        currentNode = nextNode;
        return null;
    }

    // Supporting classes
    private class Node {
        private boolean isVirtual;
        private Node realNode;

        public boolean isVirtual() {
            return isVirtual;
        }

        public Node getRealNode() {
            return realNode;
        }
    }

    private class Edge {
        private Node source;
        private Node target;

        public Node getSource() {
            return source;
        }

        public Node getTarget() {
            return target;
        }
    }
}