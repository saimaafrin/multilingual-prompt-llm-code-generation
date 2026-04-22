class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree<T> {

    /** 
     * Performs a right node rotation.
     * @param node a node to rotate
     * @return a new parent of the {@code node}
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node; // Cannot rotate right if node is null or has no left child
        }

        TreeNode<T> newParent = node.left; // The new parent will be the left child
        node.left = newParent.right; // The right child of the new parent becomes the left child of the node
        newParent.right = node; // The node becomes the right child of the new parent

        return newParent; // Return the new parent
    }
}