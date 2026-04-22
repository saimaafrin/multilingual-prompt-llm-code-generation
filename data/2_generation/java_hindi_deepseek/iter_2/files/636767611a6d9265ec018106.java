import java.util.Set;

public class Graph<V> {
    /**
     * एक वर्टेक्स में प्रवेश करने वाले भारों का योग निकालें
     * @param v वर्टेक्स
     * @return एक वर्टेक्स में प्रवेश करने वाले भारों का योग
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the vertices have weights associated with them
        // and that the weights can be accessed via a method getWeight()
        for (V vertex : v) {
            sum += getWeight(vertex); // Replace getWeight() with the actual method to get the weight of the vertex
        }
        return sum;
    }

    // Placeholder method to get the weight of a vertex
    // Replace this with the actual implementation to get the weight of a vertex
    private double getWeight(V vertex) {
        // Example implementation, replace with actual logic
        return 1.0; // Default weight
    }
}