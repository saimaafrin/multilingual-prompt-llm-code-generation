// Assuming the class has the following structure for the tree edges:
// class TreeNode {
//     TreeNode prev;
//     TreeNode next;
//     // Other fields and methods
// }

public void removeFromTreeEdgeList(TreeNode node) {
    if (node == null) {
        return;
    }

    // If the node has a previous node, update its next pointer
    if (node.prev != null) {
        node.prev.next = node.next;
    }

    // If the node has a next node, update its previous pointer
    if (node.next != null) {
        node.next.prev = node.prev;
    }

    // Clear the node's pointers to remove it from the list
    node.prev = null;
    node.next = null;
}