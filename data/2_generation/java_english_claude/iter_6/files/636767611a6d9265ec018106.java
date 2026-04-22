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
            // Get edges going to vertices in set v
            Map<V, E> edges = graph.get(vertex);
            
            // For each edge
            for (Map.Entry<V, E> edge : edges.entrySet()) {
                // If the destination vertex is in set v
                if (v.contains(edge.getKey())) {
                    // Add weight to sum if graph is weighted
                    if (isWeighted) {
                        sum += (Double) edge.getValue();
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