import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {

    private class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        
        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /** 
     * Performs a right node rotation.
     * @param node a node to rotate
     * @return a new parent of the {@code node}
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