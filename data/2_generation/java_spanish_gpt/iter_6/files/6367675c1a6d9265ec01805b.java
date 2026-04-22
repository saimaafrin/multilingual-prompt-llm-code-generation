public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public void removeFromTreeEdgeList() {
        if (head == null) {
            return; // List is empty
        }

        // Remove the head node
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null; // List becomes empty
        }

        // Remove the tail node
        if (tail != null) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                tail = null; // List becomes empty
            }
        }
    }

    // Additional methods for adding nodes, displaying the list, etc., can be added here
}