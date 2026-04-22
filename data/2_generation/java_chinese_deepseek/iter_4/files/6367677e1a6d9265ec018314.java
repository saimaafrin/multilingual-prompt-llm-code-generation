import java.util.*;

class CategoryTree {
    private Map<Integer, Boolean> activeNodes; // 假设这是一个存储节点ID及其活跃状态的映射
    private Map<Integer, List<Integer>> tree; // 假设这是一个存储树结构的映射，键为父节点ID，值为子节点ID列表

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

        // 从树中移除不活跃的节点
        for (Integer nodeId : nodesToRemove) {
            if (tree.containsKey(nodeId)) {
                // 如果节点有子节点，递归移除子节点
                removeSubtree(nodeId);
                removedCount++;
            } else {
                // 如果节点没有子节点，直接移除
                activeNodes.remove(nodeId);
                removedCount++;
            }
        }

        return removedCount;
    }

    private void removeSubtree(int nodeId) {
        if (tree.containsKey(nodeId)) {
            for (Integer childId : tree.get(nodeId)) {
                removeSubtree(childId);
            }
            tree.remove(nodeId);
        }
        activeNodes.remove(nodeId);
    }
}