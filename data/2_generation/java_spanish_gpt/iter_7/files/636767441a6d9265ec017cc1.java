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
     * Realiza una rotación a la derecha de un nodo.
     * @param node un nodo a rotar
     * @return un nuevo padre del {@code node}
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node; // No se puede rotar si el nodo es nulo o no tiene hijo izquierdo
        }

        TreeNode<T> newRoot = node.left; // El nuevo padre será el hijo izquierdo del nodo
        node.left = newRoot.right; // El hijo derecho del nuevo padre se convierte en hijo izquierdo del nodo
        newRoot.right = node; // El nodo original se convierte en el hijo derecho del nuevo padre

        return newRoot; // Retorna el nuevo padre
    }
}