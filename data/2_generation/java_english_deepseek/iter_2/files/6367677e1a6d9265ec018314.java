import java.util.*;

class Category {
    private String name;
    private List<Category> children;
    private boolean active;

    public Category(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.active = true;
    }

    public void addChild(Category child) {
        children.add(child);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public List<Category> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}

public class CategoryTree {
    private Category root;

    public CategoryTree(Category root) {
        this.root = root;
    }

    protected int removeUnusedNodes() {
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(Category node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;
        List<Category> children = node.getChildren();
        Iterator<Category> iterator = children.iterator();

        while (iterator.hasNext()) {
            Category child = iterator.next();
            if (!child.isActive()) {
                iterator.remove();
                removedCount++;
            } else {
                removedCount += removeUnusedNodesHelper(child);
            }
        }

        return removedCount;
    }

    public static void main(String[] args) {
        Category root = new Category("Root");
        Category child1 = new Category("Child1");
        Category child2 = new Category("Child2");
        Category child3 = new Category("Child3");

        root.addChild(child1);
        root.addChild(child2);
        child2.addChild(child3);

        child2.setActive(false); // Marking Child2 as inactive

        CategoryTree tree = new CategoryTree(root);
        int removedCount = tree.removeUnusedNodes();
        System.out.println("Removed " + removedCount + " inactive nodes.");
    }
}