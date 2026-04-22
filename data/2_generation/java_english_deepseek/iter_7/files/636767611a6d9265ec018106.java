import java.util.Set;

public class Graph<V> {
    private final java.util.Map<V, java.util.Map<V, Double>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new java.util.HashMap<>();
    }

    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            if (adjacencyMap.containsKey(vertex)) {
                for (Double weight : adjacencyMap.get(vertex).values()) {
                    sum += weight;
                }
            }
        }
        return sum;
    }

    // Optional: Method to add edges to the graph
    public void addEdge(V source, V destination, double weight) {
        adjacencyMap.computeIfAbsent(source, k -> new java.util.HashMap<>()).put(destination, weight);
    }
}