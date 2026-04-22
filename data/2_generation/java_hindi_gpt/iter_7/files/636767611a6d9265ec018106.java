import java.util.Set;

public class Graph<V> {
    
    // Assuming a method to get incoming weights for a vertex
    private double getIncomingWeight(V vertex) {
        // Placeholder for actual implementation
        // This should return the sum of weights of edges coming into the vertex
        return 0.0; // Replace with actual logic
    }

    /** 
     * एक वर्टेक्स में प्रवेश करने वाले भारों का योग निकालें
     * @param v वर्टेक्स
     * @return एक वर्टेक्स में प्रवेश करने वाले भारों का योग
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (V vertex : v) {
            totalWeight += getIncomingWeight(vertex);
        }
        return totalWeight;
    }
}