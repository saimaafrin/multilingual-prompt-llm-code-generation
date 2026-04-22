class Node {
    private Node next;
    private boolean isVirtual;

    public Node(Node next, boolean isVirtual) {
        this.next = next;
        this.isVirtual = isVirtual;
    }

    public Node getNext() {
        return next;
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
        Node realFrom = currentNode.isVirtual() ? getRealNode(currentNode) : currentNode;
        Node realTo = nextNode != null && nextNode.isVirtual() ? getRealNode(nextNode) : nextNode;

        return new Edge(realFrom, realTo);
    }

    private Node getRealNode(Node node) {
        // Logic to get the real equivalent of a virtual node
        // This is a placeholder; actual implementation may vary
        return node; // Assuming the node itself is returned for simplicity
    }
}