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
     * @return हटाए गए नोड्स की संख्या
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

    // Additional methods to build the tree and mark active nodes would be here
}