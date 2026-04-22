import java.util.*;

public class Graph<V> {
    // 邻接表存储图结构
    private Map<V, Map<V, Double>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * 计算进入一个顶点的权重总和
     * @param v 顶点
     * @return 进入一个顶点的权重总和
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        
        // 遍历所有顶点
        for (V vertex : adjacencyMap.keySet()) {
            Map<V, Double> edges = adjacencyMap.get(vertex);
            
            // 遍历当前顶点的所有边
            for (V destination : edges.keySet()) {
                // 如果目标顶点在传入的集合中,累加权重
                if (v.contains(destination)) {
                    totalWeight += edges.get(destination);
                }
            }
        }
        
        return totalWeight;
    }
}