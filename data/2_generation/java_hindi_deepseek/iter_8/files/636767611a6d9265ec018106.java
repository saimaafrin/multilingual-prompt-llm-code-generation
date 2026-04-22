import java.util.Set;

public class Graph<V> {
    /**
     * एक वर्टेक्स में प्रवेश करने वाले भारों का योग निकालें
     * @param v वर्टेक्स
     * @return एक वर्टेक्स में प्रवेश करने वाले भारों का योग
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

    // Dummy method to represent getting the weight of a vertex
    // Replace this with the actual implementation
    private double getWeight(V vertex) {
        // Placeholder implementation
        return 1.0; // Default weight for each vertex
    }
}