import java.util.Objects;

public class AVLTree<T extends Comparable<T>> {
    
    private class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        int height;
        
        TreeNode(T data) {
            this.data = data;
            this.height = 1;
        }
    }
    
    /**
     * 执行右旋转操作。
     * @param node 要旋转的节点
     * @return {@code node} 的新父节点
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        
        TreeNode<T> newRoot = node.left;
        if (newRoot == null) {
            return node;
        }
        
        node.left = newRoot.right;
        newRoot.right = node;
        
        // 更新高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        
        return newRoot;
    }
    
    // 辅助方法：获取节点高度
    private int getHeight(TreeNode<T> node) {
        return node == null ? 0 : node.height;
    }
}