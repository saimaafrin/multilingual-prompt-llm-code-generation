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
     * Realiza una rotación a la derecha de un nodo.
     * @param node un nodo a rotar
     * @return un nuevo padre del {@code node}
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