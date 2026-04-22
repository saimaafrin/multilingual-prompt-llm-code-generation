// Assuming the class has a reference to the tree edge lists and the node to be removed
public class TreeNode {
    TreeNode prev;
    TreeNode next;
    // Other fields and methods

    public void removeFromTreeEdgeList() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
        // Optionally, set this node's prev and next to null to fully detach it
        this.prev = null;
        this.next = null;
    }
}