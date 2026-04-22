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
     * 执行右旋转操作。
     * @param node 要旋转的节点
     * @return {@code node} 的新父节点
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node; // 无法旋转
        }

        TreeNode<T> newRoot = node.left; // 新的根节点
        node.left = newRoot.right; // 将新根的右子树赋给当前节点的左子树
        newRoot.right = node; // 当前节点成为新根的右子树

        return newRoot; // 返回新的根节点
    }
}