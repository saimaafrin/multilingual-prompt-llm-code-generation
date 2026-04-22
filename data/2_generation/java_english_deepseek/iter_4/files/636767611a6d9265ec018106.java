import java.util.Set;

public class Graph<V> {
    // Assuming that the graph is represented as a map where each vertex maps to a set of edges with weights
    private java.util.Map<V, java.util.Map<V, Double>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new java.util.HashMap<>();
    }

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(V v) {
        double sum = 0.0;
        for (java.util.Map<V, java.util.Map<V, Double>> entry : adjacencyMap.values()) {
            if (entry.containsKey(v)) {
                sum += entry.get(v);
            }
        }
        return sum;
    }

    // Additional methods to add vertices and edges would be needed to make this class functional
}