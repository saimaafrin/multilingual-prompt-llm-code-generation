import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the edges of the graph
    // and each edge has a weight associated with it.
    
    private class Edge {
        V target;
        double weight;

        Edge(V target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    private Set<Edge> getEdges(V vertex) {
        // This method should return the edges connected to the vertex
        // For the sake of this example, let's assume it returns an empty set
        return Set.of();
    }

    /**
     * 计算进入一个顶点的权重总和
     * @param v 顶点
     * @return 进入一个顶点的权重总和
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (V vertex : v) {
            Set<Edge> edges = getEdges(vertex);
            for (Edge edge : edges) {
                totalWeight += edge.weight;
            }
        }
        return totalWeight;
    }
}