import java.util.Set;

public class Graph<V> {

    /**
     * Compute the sum of the weights entering a vertex
     * @param v the vertex
     * @return the sum of the weights entering a vertex
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        // Assuming that the graph is represented as a map where each vertex maps to a list of edges with weights
        // For example: Map<V, List<Edge<V>>> adjacencyList;
        // Edge<V> could be a class that contains the target vertex and the weight of the edge

        // Iterate through all vertices in the set
        for (V vertex : v) {
            // Assuming adjacencyList is a class member that stores the graph structure
            // List<Edge<V>> edges = adjacencyList.get(vertex);
            // for (Edge<V> edge : edges) {
            //     sum += edge.getWeight();
            // }
        }

        return sum;
    }

    // Example Edge class (assuming it exists)
    private static class Edge<V> {
        private V target;
        private double weight;

        public Edge(V target, double weight) {
            this.target = target;
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }
}