import java.util.Set;

public class Graph<V> {

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the graph is represented as a map where each vertex maps to its incoming edges and their weights
        // For example: Map<V, Map<V, Double>> incomingEdges;
        // This is a placeholder implementation, as the actual graph structure is not provided.
        for (V vertex : v) {
            // Assuming incomingEdges is a map that contains the incoming edges and their weights for each vertex
            // Map<V, Double> edges = incomingEdges.get(vertex);
            // if (edges != null) {
            //     for (Double weight : edges.values()) {
            //         sum += weight;
            //     }
            // }
            // Placeholder: sum += 1.0; // Replace with actual weight calculation
        }
        return sum;
    }
}