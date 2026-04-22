import java.util.Set;

public class Graph<V> {
    // Assuming that the graph is represented as a map where each vertex maps to a set of edges with weights
    private java.util.Map<V, java.util.Map<V, Double>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new java.util.HashMap<>();
    }

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        for (V vertex : v) {
            if (adjacencyMap.containsKey(vertex)) {
                for (java.util.Map.Entry<V, Double> entry : adjacencyMap.get(vertex).entrySet()) {
                    sum += entry.getValue();
                }
            }
        }
        return sum;
    }

    // Example usage
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        // Add vertices and edges with weights here
        // Example:
        // graph.adjacencyMap.put("A", new java.util.HashMap<>());
        // graph.adjacencyMap.get("A").put("B", 1.5);
        // graph.adjacencyMap.get("A").put("C", 2.5);

        Set<String> vertices = java.util.Set.of("A", "B", "C");
        double totalWeight = graph.vertexWeight(vertices);
        System.out.println("Total weight: " + totalWeight);
    }
}