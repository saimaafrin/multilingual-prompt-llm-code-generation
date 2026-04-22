// Assuming the class has the following structure for the doubly linked list nodes
class EdgeNode {
    EdgeNode prev;
    EdgeNode next;
    // Other fields as necessary
}

public class Tree {
    private EdgeNode head; // Head of the doubly linked list
    private EdgeNode tail; // Tail of the doubly linked list

    /**
     * Elimina este borde de ambas listas doblemente enlazadas de bordes del árbol.
     */
    public void removeFromTreeEdgeList(EdgeNode node) {
        if (node == null) {
            return;
        }

        // If the node is the head
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        // If the node is the tail
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        // Optional: Clear the node's pointers to help with garbage collection
        node.prev = null;
        node.next = null;
    }
}