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
        
        // Get real nodes if virtual
        Node realCurrent = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node realNext = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;

        // Find edge connecting the nodes
        for (Edge edge : edges) {
            if ((edge.getSource() == realCurrent && edge.getTarget() == realNext) ||
                (edge.getSource() == realNext && edge.getTarget() == realCurrent)) {
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