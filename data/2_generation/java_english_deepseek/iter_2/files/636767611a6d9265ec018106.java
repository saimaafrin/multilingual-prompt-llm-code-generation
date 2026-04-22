import java.util.Set;

public class Graph<V> {

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the graph is represented as a map where each vertex maps to a list of edges
        // and each edge has a weight. This is a placeholder implementation.
        // You would need to replace this with the actual logic to sum the weights of incoming edges.
        for (V vertex : v) {
            // Example: sum += getIncomingEdges(vertex).stream().mapToDouble(Edge::getWeight).sum();
            // Replace with actual logic to get incoming edges and their weights
        }
        return sum;
    }
}