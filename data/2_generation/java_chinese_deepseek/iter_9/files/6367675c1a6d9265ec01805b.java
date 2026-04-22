import java.util.*;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;

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
}