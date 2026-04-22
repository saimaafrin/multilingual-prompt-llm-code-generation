import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get incoming edges for a vertex
    // and a method to get the weight of an edge.
    
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        
        for (V vertex : v) {
            // Assuming getIncomingEdges is a method that returns a list of incoming edges for the vertex
            for (Edge<V> edge : getIncomingEdges(vertex)) {
                totalWeight += edge.getWeight(); // Assuming getWeight returns the weight of the edge
            }
        }
        
        return totalWeight;
    }
    
    // Placeholder for Edge class
    private class Edge<V> {
        private V from;
        private V to;
        private double weight;

        public Edge(V from, V to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }

    // Placeholder for method to get incoming edges
    private Set<Edge<V>> getIncomingEdges(V vertex) {
        // Implementation to retrieve incoming edges for the vertex
        return Set.of(); // Placeholder return
    }
}