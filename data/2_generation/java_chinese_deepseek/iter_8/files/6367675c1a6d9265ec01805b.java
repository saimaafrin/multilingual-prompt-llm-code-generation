import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public void removeFromTreeEdgeList() {
        if (this.parent != null) {
            if (this.parent.left == this) {
                this.parent.left = null;
            } else if (this.parent.right == this) {
                this.parent.right = null;
            }
            this.parent = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(2);
        TreeNode rightChild = new TreeNode(3);

        root.left = leftChild;
        leftChild.parent = root;

        root.right = rightChild;
        rightChild.parent = root;

        System.out.println("Before removal:");
        System.out.println("Root's left child: " + (root.left != null ? root.left.val : "null"));
        System.out.println("Root's right child: " + (root.right != null ? root.right.val : "null"));

        leftChild.removeFromTreeEdgeList();

        System.out.println("After removal:");
        System.out.println("Root's left child: " + (root.left != null ? root.left.val : "null"));
        System.out.println("Root's right child: " + (root.right != null ? root.right.val : "null"));
    }
}