import java.util.*;

class CategoryTree {
    private Map<Integer, List<Integer>> tree;
    private Set<Integer> activeNodes;

    public CategoryTree() {
        tree = new HashMap<>();
        activeNodes = new HashSet<>();
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

    // Example usage and testing
    public static void main(String[] args) {
        CategoryTree ct = new CategoryTree();
        ct.tree.put(1, Arrays.asList(2, 3));
        ct.tree.put(2, Arrays.asList(4));
        ct.activeNodes.add(1);
        ct.activeNodes.add(2);

        int removedNodes = ct.removeUnusedNodes();
        System.out.println("Removed " + removedNodes + " unused nodes.");
    }
}