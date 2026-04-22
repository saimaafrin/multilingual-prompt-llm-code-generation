// Assuming the class has a reference to the tree edge lists and the node to be removed
public class Tree {
    private Node head; // Head of the first doubly linked list
    private Node tail; // Tail of the second doubly linked list

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * इस किनारे को पेड़ के किनारों की दोनों डबल लिंक्ड सूचियों से हटा देता है।
     */
    public void removeFromTreeEdgeList(Node nodeToRemove) {
        if (nodeToRemove == null) {
            return;
        }

        // Remove from the first doubly linked list
        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next; // If the node to remove is the head
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        // Remove from the second doubly linked list
        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            tail = nodeToRemove.next; // If the node to remove is the tail
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
    }
}