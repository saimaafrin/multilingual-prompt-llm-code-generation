// Assuming the class has access to the doubly linked list of edges
// and the necessary node structure is defined.

public class TreeNode {
    TreeNode prev;
    TreeNode next;
    // Other fields and methods
}

public class Tree {
    private TreeNode head;
    private TreeNode tail;

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

        // Clear the node's pointers
        node.prev = null;
        node.next = null;
    }
}