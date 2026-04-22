import java.util.Iterator;
import java.util.ArrayList;

public class CategoryTree {
    private Category root;
    
    protected class Category {
        private boolean active;
        private ArrayList<Category> children;
        
        public Category() {
            this.active = false;
            this.children = new ArrayList<>();
        }
        
        public boolean isActive() {
            return active;
        }
        
        public ArrayList<Category> getChildren() {
            return children;
        }
    }

    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        return removeUnusedNodesRecursive(root);
    }
    
    private int removeUnusedNodesRecursive(Category node) {
        int count = 0;
        
        Iterator<Category> iterator = node.getChildren().iterator();
        while (iterator.hasNext()) {
            Category child = iterator.next();
            count += removeUnusedNodesRecursive(child);
            
            if (!child.isActive() && child.getChildren().isEmpty()) {
                iterator.remove();
                count++;
            }
        }
        
        return count;
    }
}