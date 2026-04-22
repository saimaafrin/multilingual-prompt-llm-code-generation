import java.util.Set;

public class Graph<V,E> {

    private Map<V, Map<V, E>> graph = new HashMap<>();
    private boolean isWeighted = true;

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        
        // For each vertex in the graph
        for (V vertex : graph.keySet()) {
            // Get edges from this vertex
            Map<V, E> edges = graph.get(vertex);
            
            // For each destination vertex in v
            for (V dest : v) {
                // If there is an edge to this destination
                if (edges.containsKey(dest)) {
                    E edge = edges.get(dest);
                    // Add weight if graph is weighted
                    if (isWeighted && edge instanceof Number) {
                        sum += ((Number) edge).doubleValue();
                    }
                    // Add 1 if unweighted
                    else {
                        sum += 1.0;
                    }
                }
            }
        }
        
        return sum;
    }
}