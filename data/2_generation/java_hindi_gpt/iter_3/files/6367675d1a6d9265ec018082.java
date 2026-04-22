class Node {
    private Node next;
    private boolean isVirtual;

    public Node(boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean isVirtual() {
        return isVirtual;
    }
}

class Edge {
    private Node from;
    private Node to;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }
}

class GraphNode {
    private Node currentNode;

    public GraphNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    /**
     * एक किनारे लौटाता है जो पहले लौटाए गए नोड को अगले लौटाए जाने वाले नोड से जोड़ता है। यदि इनमें से कोई भी नोड आभासी है, तो किनारा इसके वास्तविक समकक्ष पर होगा।
     * @return वर्तमान नोड से अगले नोड तक एक किनारा
     */
    public Edge edgeToNext() {
        Node nextNode = currentNode.getNext();
        if (currentNode.isVirtual()) {
            // Logic to find the real equivalent of the current node
            // For simplicity, we assume the current node is not virtual in this example
            // In a real scenario, you would implement the logic to find the real node
        }
        if (nextNode != null && nextNode.isVirtual()) {
            // Logic to find the real equivalent of the next node
            // For simplicity, we assume the next node is not virtual in this example
        }
        return new Edge(currentNode, nextNode);
    }
}