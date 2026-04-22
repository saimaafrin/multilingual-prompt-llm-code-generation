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

    /**
     * श्रेणी वृक्ष से किसी भी निष्क्रिय नोड्स को हटा देता है।
     */
    protected int removeUnusedNodes() {
        Set<Integer> nodesToRemove = new HashSet<>();
        for (Integer node : tree.keySet()) {
            if (!activeNodes.contains(node)) {
                nodesToRemove.add(node);
            }
        }

        for (Integer node : nodesToRemove) {
            tree.remove(node);
        }

        return nodesToRemove.size();
    }
}