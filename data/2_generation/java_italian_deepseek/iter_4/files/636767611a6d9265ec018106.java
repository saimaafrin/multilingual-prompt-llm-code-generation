import java.util.Set;

public class GraphUtils<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            // Assuming each vertex has a weight associated with it
            // Replace getWeight() with the actual method to get the weight of the vertex
            sum += getWeight(vertex);
        }
        return sum;
    }

    // Placeholder method to get the weight of a vertex
    // Replace this with the actual implementation to get the weight
    private double getWeight(V vertex) {
        // Example implementation, replace with actual logic
        return 1.0; // Default weight
    }
}