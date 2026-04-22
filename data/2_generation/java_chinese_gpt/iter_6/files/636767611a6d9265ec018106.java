import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the edges of the graph
    // and each edge has a method to get its weight and destination vertex.
    
    private Set<Edge<V>> edges; // Set of edges in the graph

    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;

        for (Edge<V> edge : edges) {
            if (v.contains(edge.getDestination())) {
                totalWeight += edge.getWeight();
            }
        }

        return totalWeight;
    }

    // Edge class representing an edge in the graph
    private static class Edge<V> {
        private V destination;
        private double weight;

        public Edge(V destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public V getDestination() {
            return destination;
        }

        public double getWeight() {
            return weight;
        }
    }
}