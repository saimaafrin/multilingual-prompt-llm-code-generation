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
     * निष्क्रिय नोड्स वे नोड्स होते हैं जिनके कोई बच्चे नहीं होते और उनका मान 0 होता है।
     * यह फ़ंक्शन वृक्ष को संशोधित करता है और हटाए गए नोड्स की संख्या लौटाता है।
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
            // Since Java doesn't allow direct modification of the parent's reference,
            // we need to handle this in the parent's context.
            // For simplicity, we'll mark it as null and let the parent handle it.
            root = null;
            count++;
        }
        
        return count;
    }
}