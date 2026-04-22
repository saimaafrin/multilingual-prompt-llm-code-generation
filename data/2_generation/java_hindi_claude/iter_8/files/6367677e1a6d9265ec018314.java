import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private boolean active;
    private List<Category> children;
    private Category parent;
    
    public void removeInactiveNodes() {
        if (children != null && !children.isEmpty()) {
            Iterator<Category> iterator = children.iterator();
            while (iterator.hasNext()) {
                Category child = iterator.next();
                child.removeInactiveNodes();
                if (!child.active && (child.children == null || child.children.isEmpty())) {
                    iterator.remove();
                }
            }
        }
    }
    
    // Constructor and other methods omitted for brevity
    public Category() {
        this.active = true;
        this.children = new ArrayList<>();
    }
}