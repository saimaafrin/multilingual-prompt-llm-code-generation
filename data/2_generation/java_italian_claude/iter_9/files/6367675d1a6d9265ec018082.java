import java.util.*;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;
    private int currentNodeIndex;

    // Constructor and other methods...

    /**
     * Restituisce un arco che collega il nodo precedentemente restituito con il nodo che verrà restituito successivamente. 
     * Se uno dei nodi menzionati è virtuale, l'arco sarà incidente al suo corrispondente reale.
     * @return un arco dal nodo corrente al nodo successivo
     */
    public Edge edgeToNext() {
        if (nodes == null || nodes.isEmpty() || currentNodeIndex >= nodes.size() - 1) {
            return null;
        }

        Node currentNode = nodes.get(currentNodeIndex);
        Node nextNode = nodes.get(currentNodeIndex + 1);

        // Get real nodes if virtual
        Node realCurrentNode = currentNode.isVirtual() ? currentNode.getRealNode() : currentNode;
        Node realNextNode = nextNode.isVirtual() ? nextNode.getRealNode() : nextNode;

        // Find edge between real nodes
        for (Edge edge : edges) {
            if ((edge.getSource().equals(realCurrentNode) && edge.getDestination().equals(realNextNode)) ||
                (edge.getSource().equals(realNextNode) && edge.getDestination().equals(realCurrentNode))) {
                return edge;
            }
        }

        return null;
    }
}

class Node {
    private boolean isVirtual;
    private Node realNode;
    
    public boolean isVirtual() {
        return isVirtual;
    }
    
    public Node getRealNode() {
        return realNode;
    }
}

class Edge {
    private Node source;
    private Node destination;
    
    public Node getSource() {
        return source;
    }
    
    public Node getDestination() {
        return destination;
    }
}