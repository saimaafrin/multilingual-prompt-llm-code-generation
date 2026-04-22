import java.util.Set;

public class Graph<V> {
    // Assuming a map to store the weights of edges entering each vertex
    private java.util.Map<V, Double> incomingWeights;

    public Graph() {
        incomingWeights = new java.util.HashMap<>();
    }

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            if (incomingWeights.containsKey(vertex)) {
                sum += incomingWeights.get(vertex);
            }
        }
        return sum;
    }

    // Example method to add an incoming weight to a vertex
    public void addIncomingWeight(V vertex, double weight) {
        incomingWeights.put(vertex, incomingWeights.getOrDefault(vertex, 0.0) + weight);
    }
}