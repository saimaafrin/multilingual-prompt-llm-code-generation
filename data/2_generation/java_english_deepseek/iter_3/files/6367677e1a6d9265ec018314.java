import java.util.*;

class CategoryNode {
    String name;
    boolean active;
    List<CategoryNode> children;

    CategoryNode(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.children = new ArrayList<>();
    }

    void addChild(CategoryNode child) {
        this.children.add(child);
    }
}

class CategoryTree {
    private CategoryNode root;

    CategoryTree(CategoryNode root) {
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