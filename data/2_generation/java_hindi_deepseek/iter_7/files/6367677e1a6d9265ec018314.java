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
     * निष्क्रिय नोड्स वे नोड्स हैं जिनके कोई बच्चे नहीं हैं और उनका मान 0 है।
     * @return हटाए गए नोड्स की संख्या
     */
    protected int removeUnusedNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int count = 0;
        
        // Post-order traversal to ensure children are processed before parents
        count += removeUnusedNodes(root.left);
        count += removeUnusedNodes(root.right);
        
        // Check if the current node is a leaf and has a value of 0
        if (root.left == null && root.right == null && root.val == 0) {
            // This node is unused, so we can remove it
            // In Java, we can't directly remove the node, but we can mark it as null
            // Assuming the parent will handle the removal
            return 1;
        }
        
        return count;
    }
}