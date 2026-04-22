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

public class Graph {
    private Node currentNode;

    public Graph(Node startNode) {
        this.currentNode = startNode;
    }

    /**
     * एक किनारे लौटाता है जो पहले लौटाए गए नोड को अगले लौटाए जाने वाले नोड से जोड़ता है। यदि इनमें से कोई भी नोड आभासी है, तो किनारा इसके वास्तविक समकक्ष पर होगा।
     * @return वर्तमान नोड से अगले नोड तक एक किनारा
     */
    public Edge edgeToNext() {
        Node nextNode = currentNode.getNext();
        if (nextNode == null) {
            return null; // या कोई अन्य हैंडलिंग
        }

        // यदि वर्तमान नोड या अगला नोड आभासी है, तो वास्तविक समकक्ष पर जाएं
        Node fromNode = currentNode.isVirtual() ? getRealEquivalent(currentNode) : currentNode;
        Node toNode = nextNode.isVirtual() ? getRealEquivalent(nextNode) : nextNode;

        return new Edge(fromNode, toNode);
    }

    private Node getRealEquivalent(Node node) {
        // यहाँ वास्तविक समकक्ष प्राप्त करने की लॉजिक लागू करें
        // यह एक प्लेसहोल्डर है, वास्तविक कार्यान्वयन आवश्यक है
        return node; // अस्थायी रूप से खुद को लौटाता है
    }
}