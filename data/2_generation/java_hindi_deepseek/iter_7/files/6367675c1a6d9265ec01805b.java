// Assuming the class has the following structure for the tree edges
class TreeNode {
    TreeNode prev;
    TreeNode next;
    // Other fields and methods
}

public class Tree {
    private TreeNode head; // Head of the doubly linked list
    private TreeNode tail; // Tail of the doubly linked list

    /**
     * इस किनारे को पेड़ के किनारों की दोनों डबल लिंक्ड सूचियों से हटा देता है।
     */
    public void removeFromTreeEdgeList(TreeNode node) {
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

        // Clear the node's links
        node.prev = null;
        node.next = null;
    }
}