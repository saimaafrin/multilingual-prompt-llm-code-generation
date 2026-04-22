import java.util.ArrayList;
import java.util.List;

public class CategoryTree {
    private CategoryNode root;
    
    protected class CategoryNode {
        private boolean active;
        private List<CategoryNode> children;
        
        public CategoryNode() {
            this.active = false;
            this.children = new ArrayList<>();
        }
        
        public boolean isActive() {
            return active;
        }
        
        public List<CategoryNode> getChildren() {
            return children;
        }
    }

    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesRecursive(root);
    }
    
    private int removeUnusedNodesRecursive(CategoryNode node) {
        int removedCount = 0;
        
        // Create a list to store children that need to be removed
        List<CategoryNode> nodesToRemove = new ArrayList<>();
        
        // Recursively process all children
        for (CategoryNode child : node.getChildren()) {
            removedCount += removeUnusedNodesRecursive(child);
            
            // If child is inactive and has no children, mark for removal
            if (!child.isActive() && child.getChildren().isEmpty()) {
                nodesToRemove.add(child);
                removedCount++;
            }
        }
        
        // Remove marked nodes from children list
        node.getChildren().removeAll(nodesToRemove);
        
        return removedCount;
    }
}