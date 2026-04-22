import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the edges of the graph
    // and each edge has a method to get its weight and destination vertex.
    
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        
        for (V vertex : v) {
            // Assuming getIncomingEdges is a method that returns the incoming edges for the vertex
            for (Edge<V> edge : getIncomingEdges(vertex)) {
                totalWeight += edge.getWeight();
            }
        }
        
        return totalWeight;
    }
    
    // Placeholder for Edge class
    private class Edge<V> {
        private V destination;
        private double weight;

        public Edge(V destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }

    // Placeholder for method to get incoming edges
    private Set<Edge<V>> getIncomingEdges(V vertex) {
        // Implementation to retrieve incoming edges for the vertex
        return Set.of(); // Return an empty set for placeholder
    }
}