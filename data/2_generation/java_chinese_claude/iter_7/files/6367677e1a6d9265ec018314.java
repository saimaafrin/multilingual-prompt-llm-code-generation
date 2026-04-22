import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CategoryTree {
    private CategoryNode root;
    private int totalNodes = 0;
    
    protected class CategoryNode {
        private boolean isActive;
        private List<CategoryNode> children;
        
        public CategoryNode() {
            this.isActive = false;
            this.children = new ArrayList<>();
        }
    }

    protected int removeUnusedNodes() {
        int removedCount = 0;
        if (root != null) {
            removedCount = removeUnusedNodesRecursive(root);
        }
        totalNodes -= removedCount;
        return removedCount;
    }

    private int removeUnusedNodesRecursive(CategoryNode node) {
        int count = 0;
        
        Iterator<CategoryNode> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            CategoryNode child = iterator.next();
            count += removeUnusedNodesRecursive(child);
            
            if (!child.isActive && child.children.isEmpty()) {
                iterator.remove();
                count++;
            }
        }
        
        return count;
    }
}