import java.util.Set;

public class Graph<V> {

    /**
     * 计算进入一个顶点的权重总和
     * @param v 顶点
     * @return 进入一个顶点的权重总和
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        // 假设我们有一个邻接表来表示图
        // 这里假设图的边权重存储在某个结构中，例如 Map<V, Map<V, Double>> adjacencyMap
        // 遍历所有顶点，计算进入顶点 v 的权重总和
        for (V vertex : v) {
            // 假设 adjacencyMap 是一个 Map<V, Map<V, Double>>，表示图的邻接表
            // 这里假设 adjacencyMap 已经初始化并包含了图的边权重
            if (adjacencyMap.containsKey(vertex)) {
                for (Map.Entry<V, Double> entry : adjacencyMap.get(vertex).entrySet()) {
                    if (entry.getKey().equals(v)) {
                        totalWeight += entry.getValue();
                    }
                }
            }
        }
        return totalWeight;
    }

    // 假设 adjacencyMap 是图的邻接表
    private Map<V, Map<V, Double>> adjacencyMap;

    // 构造函数
    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    // 添加边的方法
    public void addEdge(V source, V destination, double weight) {
        adjacencyMap.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
    }
}