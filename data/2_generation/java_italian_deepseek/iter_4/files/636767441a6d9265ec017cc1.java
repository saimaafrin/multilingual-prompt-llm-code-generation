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

public class TreeRotation<T> {

    /**
     * Esegue una rotazione a destra del nodo.
     * @param node un nodo da ruotare
     * @return un nuovo genitore del {@code node}
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node;
        }

        TreeNode<T> newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;

        return newParent;
    }
}