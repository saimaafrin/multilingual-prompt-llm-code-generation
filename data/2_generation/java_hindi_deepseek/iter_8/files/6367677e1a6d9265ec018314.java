import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeUtil {
    /**
     * श्रेणी वृक्ष से किसी भी निष्क्रिय नोड्स को हटा देता है।
     * @return the number of nodes removed
     */
    protected int removeUnusedNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int count = 0;
        if (isLeaf(root.left)) {
            root.left = null;
            count++;
        } else {
            count += removeUnusedNodes(root.left);
        }
        
        if (isLeaf(root.right)) {
            root.right = null;
            count++;
        } else {
            count += removeUnusedNodes(root.right);
        }
        
        return count;
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}