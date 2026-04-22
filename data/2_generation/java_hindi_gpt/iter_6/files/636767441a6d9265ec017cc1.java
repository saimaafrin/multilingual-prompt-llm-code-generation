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
     * दाहिनी नोड घुमाने का कार्य करता है।
     * @param node वह नोड जिसे घुमाना है
     * @return {@code node} का नया पैरेंट
     */
    private TreeNode<T> rotateRight(TreeNode<T> node) {
        if (node == null || node.left == null) {
            return node; // Cannot rotate right if node is null or left child is null
        }

        TreeNode<T> newRoot = node.left; // New root will be the left child
        node.left = newRoot.right; // Right child of new root becomes left child of old root
        newRoot.right = node; // Old root becomes right child of new root

        return newRoot; // Return the new root
    }
}