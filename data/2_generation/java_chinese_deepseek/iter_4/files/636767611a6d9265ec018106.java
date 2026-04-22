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
        for (V vertex : v) {
            totalWeight += getIncomingEdgeWeight(vertex);
        }
        return totalWeight;
    }

    // 假设这个方法返回进入某个顶点的边的权重
    private double getIncomingEdgeWeight(V vertex) {
        // 这里应该实现具体的逻辑来获取进入顶点的边的权重
        // 例如，从图的邻接表或邻接矩阵中获取
        // 这里只是一个示例，返回一个固定的权重值
        return 1.0; // 假设每条边的权重都是1.0
    }
}