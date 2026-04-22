import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class Category {
    private String name;
    private boolean isActive;
    private List<Category> children;

    public Category(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void addChild(Category child) {
        children.add(child);
    }
}

public class CategoryTree {
    private Category root;

    public CategoryTree(Category root) {
        this.root = root;
    }

    /** 
     * Elimina cualquier nodo inactivo del árbol con elementos de tipo "Category".
     */
    protected int removeUnusedNodes() {
        return removeInactiveNodes(root);
    }

    private int removeInactiveNodes(Category node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;

        // Iterate through children and remove inactive nodes
        Iterator<Category> iterator = node.getChildren().iterator();
        while (iterator.hasNext()) {
            Category child = iterator.next();
            removedCount += removeInactiveNodes(child);

            if (!child.isActive()) {
                iterator.remove();
                removedCount++;
            }
        }

        return removedCount;
    }

    public static void main(String[] args) {
        Category root = new Category("Root", true);
        Category child1 = new Category("Child1", false);
        Category child2 = new Category("Child2", true);
        Category grandChild = new Category("GrandChild", false);

        root.addChild(child1);
        root.addChild(child2);
        child2.addChild(grandChild);

        CategoryTree tree = new CategoryTree(root);
        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed nodes: " + removedNodes);
    }
}