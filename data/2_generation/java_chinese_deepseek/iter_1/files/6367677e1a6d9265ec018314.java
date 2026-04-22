import java.util.*;

class CategoryTree {
    private Map<Integer, Boolean> activeNodes; // 假设这是一个存储节点是否活跃的映射
    private Map<Integer, List<Integer>> tree; // 假设这是一个存储树的邻接表

    public CategoryTree() {
        activeNodes = new HashMap<>();
        tree = new HashMap<>();
    }

    /**
     * 从类别树中移除所有不活跃的节点。
     * @return 返回被移除的节点数量
     */
    protected int removeUnusedNodes() {
        int removedCount = 0;
        Set<Integer> nodesToRemove = new HashSet<>();

        // 遍历所有节点，找出不活跃的节点
        for (Map.Entry<Integer, Boolean> entry : activeNodes.entrySet()) {
            if (!entry.getValue()) {
                nodesToRemove.add(entry.getKey());
            }
        }

        // 移除不活跃的节点
        for (int node : nodesToRemove) {
            if (tree.containsKey(node)) {
                tree.remove(node);
                removedCount++;
            }
        }

        // 从邻接表中移除所有指向不活跃节点的边
        for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
            List<Integer> children = entry.getValue();
            children.removeAll(nodesToRemove);
        }

        // 从activeNodes中移除不活跃的节点
        for (int node : nodesToRemove) {
            activeNodes.remove(node);
        }

        return removedCount;
    }
}