import java.util.Iterator;
import java.util.ArrayList;

public class Category {
    private boolean active;
    private ArrayList<Category> children;
    
    protected int removeUnusedNodes() {
        int removedCount = 0;
        
        // Base case - if no children, check if current node is inactive
        if (children == null || children.isEmpty()) {
            if (!active) {
                return 1;
            }
            return 0;
        }
        
        // Recursively process children
        Iterator<Category> iter = children.iterator();
        while (iter.hasNext()) {
            Category child = iter.next();
            removedCount += child.removeUnusedNodes();
            
            // Remove child if it has no children and is inactive
            if (!child.active && (child.children == null || child.children.isEmpty())) {
                iter.remove();
            }
        }
        
        // Check if current node should be removed
        if (!active && children.isEmpty()) {
            removedCount++;
        }
        
        return removedCount;
    }
}