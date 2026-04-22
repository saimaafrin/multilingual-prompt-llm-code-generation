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
     * 执行右旋转操作。
     * @param node 要旋转的节点
     * @return {@code node} 的新父节点
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node;
        }

        TreeNode<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        return newRoot;
    }
}