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
     * @return हटाए गए नोड्स की संख्या
     */
    protected int removeUnusedNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int count = 0;
        
        // Post-order traversal to ensure children are processed before parents
        root.left = removeUnusedNodesHelper(root.left, count);
        root.right = removeUnusedNodesHelper(root.right, count);
        
        // Check if the current node is a leaf and has a value of 0
        if (root.left == null && root.right == null && root.val == 0) {
            return count + 1;
        }
        
        return count;
    }
    
    private TreeNode removeUnusedNodesHelper(TreeNode node, int count) {
        if (node == null) {
            return null;
        }
        
        node.left = removeUnusedNodesHelper(node.left, count);
        node.right = removeUnusedNodesHelper(node.right, count);
        
        // If the node is a leaf and has a value of 0, remove it
        if (node.left == null && node.right == null && node.val == 0) {
            count++;
            return null;
        }
        
        return node;
    }
}