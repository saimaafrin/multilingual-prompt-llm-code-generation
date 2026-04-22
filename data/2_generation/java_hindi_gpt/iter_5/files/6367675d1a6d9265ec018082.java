import java.util.Objects;

class Node {
    private Edge edge;
    private Node next;

    public Node(Edge edge, Node next) {
        this.edge = edge;
        this.next = next;
    }

    public Edge getEdge() {
        return edge;
    }

    public Node getNext() {
        return next;
    }
}

class Edge {
    private String label;

    public Edge(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

public class GraphNode {
    private Node currentNode;

    public GraphNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    /**
     * एक किनारे लौटाता है जो पहले लौटाए गए नोड को अगले लौटाए जाने वाले नोड से जोड़ता है। यदि इनमें से कोई भी नोड आभासी है, तो किनारा इसके वास्तविक समकक्ष पर होगा।
     * @return वर्तमान नोड से अगले नोड तक एक किनारा
     */
    public Edge edgeToNext() {
        if (currentNode == null || currentNode.getNext() == null) {
            return null; // No edge if current or next node is null
        }
        Edge nextEdge = currentNode.getEdge();
        Node nextNode = currentNode.getNext();
        
        // If the next node is virtual, return the edge of the next node
        if (nextNode.getEdge() == null) {
            return nextEdge; // Return the edge of the current node
        }
        return nextNode.getEdge(); // Return the edge of the next node
    }
}