import java.util.Set;

public class Graph<V> {

    /**
     * 计算进入一个顶点的权重总和
     * @param v 顶点
     * @return 进入一个顶点的权重总和
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        // 假设我们有一个邻接表来表示图的结构
        // 这里假设邻接表中的每个顶点都有一个与之关联的权重
        // 遍历所有顶点，累加进入该顶点的权重
        for (V vertex : v) {
            // 假设 getIncomingEdges 返回进入该顶点的所有边的集合
            // 假设 getWeight 返回边的权重
            for (Edge<V> edge : getIncomingEdges(vertex)) {
                totalWeight += edge.getWeight();
            }
        }
        return totalWeight;
    }

    // 假设的辅助方法，返回进入某个顶点的所有边
    private Set<Edge<V>> getIncomingEdges(V vertex) {
        // 这里应该返回进入该顶点的所有边的集合
        // 由于这是一个示例，我们返回一个空的集合
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