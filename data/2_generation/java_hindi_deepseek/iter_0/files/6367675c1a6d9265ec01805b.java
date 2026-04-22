// Assuming the class has a reference to the tree edge lists and the edge to be removed
public class Tree {
    private Node head; // Head of the doubly linked list
    private Node tail; // Tail of the doubly linked list

    // Node class representing an edge in the tree
    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Method to remove an edge from the doubly linked list
    public void removeFromTreeEdgeList(Node edgeToRemove) {
        if (edgeToRemove == null) {
            return;
        }

        // If the edge to remove is the head
        if (edgeToRemove == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If the list becomes empty
            }
        }
        // If the edge to remove is the tail
        else if (edgeToRemove == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null; // If the list becomes empty
            }
        }
        // If the edge to remove is in the middle
        else {
            edgeToRemove.prev.next = edgeToRemove.next;
            edgeToRemove.next.prev = edgeToRemove.prev;
        }

        // Clear the references of the removed edge
        edgeToRemove.prev = null;
        edgeToRemove.next = null;
    }
}