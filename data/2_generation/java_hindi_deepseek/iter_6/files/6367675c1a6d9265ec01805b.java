// Assuming the class has a reference to the node and its previous and next nodes in the tree edge list
public class TreeNode {
    TreeNode prev;
    TreeNode next;

    public void removeFromTreeEdgeList() {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
        this.prev = null;
        this.next = null;
    }
}