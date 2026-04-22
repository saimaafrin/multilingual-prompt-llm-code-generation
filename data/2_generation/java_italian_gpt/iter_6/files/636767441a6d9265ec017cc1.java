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
     * Esegue una rotazione a destra del nodo.
     * @param node un nodo da ruotare
     * @return un nuovo genitore del {@code node}
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node; // Non è possibile ruotare
        }

        TreeNode<T> newRoot = node.left; // Il nuovo genitore sarà il nodo sinistro
        node.left = newRoot.right; // Il nodo destro del nuovo genitore diventa il nodo sinistro del nodo originale
        newRoot.right = node; // Il nodo originale diventa il nodo destro del nuovo genitore

        return newRoot; // Restituisce il nuovo genitore
    }
}