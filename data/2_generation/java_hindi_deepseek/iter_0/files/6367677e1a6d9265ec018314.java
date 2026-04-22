import java.util.*;

class CategoryTree {
    private Map<Integer, List<Integer>> tree;
    private Set<Integer> activeNodes;

    public CategoryTree() {
        tree = new HashMap<>();
        activeNodes = new HashSet<>();
    }

    public void addNode(int parent, int node) {
        tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
    }

    public void markActive(int node) {
        activeNodes.add(node);
    }

    protected int removeUnusedNodes() {
        Set<Integer> nodesToRemove = new HashSet<>();
        for (Integer node : tree.keySet()) {
            if (!activeNodes.contains(node) && !hasActiveDescendants(node)) {
                nodesToRemove.add(node);
            }
        }

        for (Integer node : nodesToRemove) {
            tree.remove(node);
        }

        return nodesToRemove.size();
    }

    private boolean hasActiveDescendants(int node) {
        if (activeNodes.contains(node)) {
            return true;
        }

        List<Integer> children = tree.get(node);
        if (children == null) {
            return false;
        }

        for (Integer child : children) {
            if (hasActiveDescendants(child)) {
                return true;
            }
        }

        return false;
    }
}