import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the incoming edges for a vertex
    private double getIncomingWeight(V vertex) {
        // Placeholder for actual implementation
        // This should return the sum of weights of edges entering the vertex
        return 0.0; // Replace with actual logic
    }

    /** 
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (V vertex : v) {
            totalWeight += getIncomingWeight(vertex);
        }
        return totalWeight;
    }
}