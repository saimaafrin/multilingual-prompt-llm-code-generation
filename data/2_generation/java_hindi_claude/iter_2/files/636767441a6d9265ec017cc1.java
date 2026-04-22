import java.util.Objects;

public class BinaryTree {
    
    private static class Node {
        int value;
        Node left;
        Node right;
        
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    /**
     * Performs a right node rotation.
     * @param node a node to rotate
     * @return a new parent of the {@code node}
     */
    private Node rotateRight(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        
        return newParent;
    }
}