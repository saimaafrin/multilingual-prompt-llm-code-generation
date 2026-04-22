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

private TreeNode<T> rotateRight(TreeNode<T> node) {
    if (node == null || node.left == null) {
        return node; // Cannot rotate right if node is null or has no left child
    }

    TreeNode<T> newRoot = node.left; // The new root will be the left child
    node.left = newRoot.right; // The right child of the new root becomes the left child of the old root
    newRoot.right = node; // The old root becomes the right child of the new root

    return newRoot; // Return the new root
}