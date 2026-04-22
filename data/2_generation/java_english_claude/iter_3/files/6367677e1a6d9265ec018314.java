import java.util.Iterator;
import java.util.ArrayList;

public class Category {
    private boolean active;
    private ArrayList<Category> children;
    
    /**
     * Removes any inactive nodes from the Category tree.
     * @return The number of nodes removed
     */
    protected int removeUnusedNodes() {
        int nodesRemoved = 0;
        
        if (children != null && !children.isEmpty()) {
            Iterator<Category> iter = children.iterator();
            while (iter.hasNext()) {
                Category child = iter.next();
                nodesRemoved += child.removeUnusedNodes();
                
                if (!child.active && (child.children == null || child.children.isEmpty())) {
                    iter.remove();
                    nodesRemoved++;
                }
            }
        }
        
        return nodesRemoved;
    }
}