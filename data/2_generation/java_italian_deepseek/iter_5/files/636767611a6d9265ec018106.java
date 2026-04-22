import java.util.Set;

public class GraphUtils<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the graph is represented as a map of vertices to their incoming edges with weights
        // For example: Map<V, Map<V, Double>> graph;
        // Where graph.get(v) returns a map of incoming edges to v with their weights

        // Iterate over all vertices in the set
        for (V vertex : v) {
            // Assuming that the graph is accessible within this method
            // For each vertex, sum the weights of incoming edges
            if (graph.containsKey(vertex)) {
                for (Double weight : graph.get(vertex).values()) {
                    sum += weight;
                }
            }
        }
        return sum;
    }

    // Assuming the graph is stored as a class member
    private Map<V, Map<V, Double>> graph;

    // Constructor to initialize the graph
    public GraphUtils(Map<V, Map<V, Double>> graph) {
        this.graph = graph;
    }
}