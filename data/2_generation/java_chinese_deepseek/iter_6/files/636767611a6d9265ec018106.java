import java.util.Set;

public class Graph<V> {

    /**
     * 计算进入一个顶点的权重总和
     * @param v 顶点
     * @return 进入一个顶点的权重总和
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        // 假设我们有一个方法来获取进入顶点的边的权重
        // 这里假设 getIncomingEdges 返回一个包含所有进入顶点的边的集合
        // 并且每个边都有一个 getWeight 方法返回边的权重
        for (Edge<V> edge : getIncomingEdges(v)) {
            totalWeight += edge.getWeight();
        }
        return totalWeight;
    }

    // 假设的辅助方法，返回进入顶点的边的集合
    private Set<Edge<V>> getIncomingEdges(V vertex) {
        // 这里应该实现获取进入顶点的边的逻辑
        // 由于没有具体的图结构，这里返回一个空集合
        return Set.of();
    }

    // 假设的边类
    private static class Edge<V> {
        private final double weight;

        public Edge(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }
}