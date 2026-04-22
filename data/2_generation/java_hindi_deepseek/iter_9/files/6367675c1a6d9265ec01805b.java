// Assuming the class has the following structure for the tree edges:
// Each node has a reference to the previous and next node in the list.

class TreeNode {
    TreeNode prev;
    TreeNode next;
    // Other fields and methods...

    public void removeFromTreeEdgeList() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
        // Optionally, you can set this node's prev and next to null
        this.prev = null;
        this.next = null;
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();

        // Linking nodes
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;

        // Removing node2 from the list
        node2.removeFromTreeEdgeList();

        // Now node1.next should point to node3, and node3.prev should point to node1
        System.out.println(node1.next == node3); // Should print true
        System.out.println(node3.prev == node1); // Should print true
    }
}