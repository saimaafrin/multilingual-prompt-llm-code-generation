class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeRotation<T> {

    /**
     * दाहिनी नोड घुमाने का कार्य करता है।
     * @param node वह नोड जिसे घुमाना है
     * @return {@code node} का नया पैरेंट
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