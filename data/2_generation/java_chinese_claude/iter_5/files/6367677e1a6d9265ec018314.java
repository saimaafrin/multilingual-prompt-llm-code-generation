import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CategoryTree {
    private CategoryNode root;
    private int totalNodes = 0;
    
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

    /**
     * 从类别树中移除所有不活跃的节点。
     * @return 被移除的节点数量
     */
    protected int removeUnusedNodes() {
        if (root == null) {
            return 0;
        }
        
        int initialCount = totalNodes;
        removeUnusedNodesRecursive(root);
        
        return initialCount - totalNodes;
    }
    
    private void removeUnusedNodesRecursive(CategoryNode node) {
        if (node == null) {
            return;
        }
        
        Iterator<CategoryNode> iterator = node.getChildren().iterator();
        while (iterator.hasNext()) {
            CategoryNode child = iterator.next();
            removeUnusedNodesRecursive(child);
            
            if (!child.isActive() && child.getChildren().isEmpty()) {
                iterator.remove();
                totalNodes--;
            }
        }
    }
}