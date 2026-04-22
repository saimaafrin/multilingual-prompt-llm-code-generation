// Assuming the class has a reference to the tree edge lists and the edge to be removed
public class Tree {
    private Node head; // Assuming Node is a class representing a node in the doubly linked list

    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void removeFromTreeEdgeList(Node edgeToRemove) {
        if (edgeToRemove == null) {
            return;
        }

        // If the edge to remove is the head of the list
        if (edgeToRemove.prev == null) {
            head = edgeToRemove.next;
        } else {
            edgeToRemove.prev.next = edgeToRemove.next;
        }

        // If the edge to remove is not the last node
        if (edgeToRemove.next != null) {
            edgeToRemove.next.prev = edgeToRemove.prev;
        }

        // Clear the references to ensure the node is removed
        edgeToRemove.prev = null;
        edgeToRemove.next = null;
    }
}