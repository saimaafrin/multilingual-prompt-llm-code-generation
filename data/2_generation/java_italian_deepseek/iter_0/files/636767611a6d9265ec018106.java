import java.util.Set;

public class Graph<V> {

    /**
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the graph is represented as a map of vertices to their incoming edges with weights
        // For example: Map<V, Map<V, Double>> incomingEdges;
        // Where incomingEdges.get(v) returns a map of vertices that have edges pointing to v, with their weights

        // Iterate over all vertices that have edges pointing to v
        for (V source : incomingEdges.keySet()) {
            if (incomingEdges.get(source).containsKey(v)) {
                sum += incomingEdges.get(source).get(v);
            }
        }
        return sum;
    }

    // Assuming the graph structure is represented as follows:
    private Map<V, Map<V, Double>> incomingEdges;

    // Constructor to initialize the graph
    public Graph() {
        incomingEdges = new HashMap<>();
    }

    // Method to add an edge to the graph
    public void addEdge(V source, V target, double weight) {
        incomingEdges.computeIfAbsent(target, k -> new HashMap<>()).put(source, weight);
    }
}