import java.util.Iterator;
import java.util.LinkedList;

class Category {
    private String name;
    private boolean active;
    private LinkedList<Category> children;

    public Category(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.children = new LinkedList<>();
    }

    public boolean isActive() {
        return active;
    }

    public void addChild(Category child) {
        children.add(child);
    }

    public LinkedList<Category> getChildren() {
        return children;
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

    private int removeInactiveNodes(Category category) {
        if (category == null) {
            return 0;
        }

        Iterator<Category> iterator = category.getChildren().iterator();
        int removedCount = 0;

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
        Category grandChild1 = new Category("GrandChild1", false);
        Category grandChild2 = new Category("GrandChild2", true);

        root.addChild(child1);
        root.addChild(child2);
        child2.addChild(grandChild1);
        child2.addChild(grandChild2);

        CategoryTree tree = new CategoryTree(root);
        int removedNodes = tree.removeUnusedNodes();
        System.out.println("Removed nodes: " + removedNodes);
    }
}