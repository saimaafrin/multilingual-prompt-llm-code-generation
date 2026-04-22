import java.util.*;

public class Graph<V> {
    // Adjacency list representation using HashMap
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
        
        // For each vertex in the input set
        for (V vertex : v) {
            // Check all vertices in the graph
            for (Map.Entry<V, Map<V, Double>> entry : adjacencyMap.entrySet()) {
                Map<V, Double> edges = entry.getValue();
                // If there is an edge to our target vertex, add its weight
                if (edges.containsKey(vertex)) {
                    totalWeight += edges.get(vertex);
                }
            }
        }
        
        return totalWeight;
    }
}