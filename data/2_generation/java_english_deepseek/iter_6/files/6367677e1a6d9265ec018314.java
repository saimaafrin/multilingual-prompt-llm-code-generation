import java.util.*;

class CategoryNode {
    int id;
    boolean active;
    List<CategoryNode> children;

    public CategoryNode(int id, boolean active) {
        this.id = id;
        this.active = active;
        this.children = new ArrayList<>();
    }
}

class CategoryTree {
    private CategoryNode root;

    public CategoryTree(CategoryNode root) {
        this.root = root;
    }

    protected int removeUnusedNodes() {
        return removeUnusedNodesHelper(root);
    }

    private int removeUnusedNodesHelper(CategoryNode node) {
        if (node == null) {
            return 0;
        }

        int removedCount = 0;
        Iterator<CategoryNode> iterator = node.children.iterator();
        while (iterator.hasNext()) {
            CategoryNode child = iterator.next();
            if (!child.active) {
                iterator.remove();
                removedCount++;
            } else {
                removedCount += removeUnusedNodesHelper(child);
            }
        }

        return removedCount;
    }
}