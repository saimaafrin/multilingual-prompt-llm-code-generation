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
            return null; // या कोई अन्य उपयुक्त कार्रवाई
        }
        return currentNode.getEdge();
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge("Edge1");
        Edge edge2 = new Edge("Edge2");
        Node nextNode = new Node(edge2, null);
        Node currentNode = new Node(edge1, nextNode);
        GraphNode graphNode = new GraphNode(currentNode);

        Edge edgeToNext = graphNode.edgeToNext();
        if (edgeToNext != null) {
            System.out.println("Edge to next node: " + edgeToNext.getLabel());
        } else {
            System.out.println("No edge to next node.");
        }
    }
}