import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the edges of the graph
    // This is a placeholder for the actual edge representation
    private Set<Edge<V>> edges;

    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        
        for (Edge<V> edge : edges) {
            if (v.contains(edge.getDestination())) {
                totalWeight += edge.getWeight();
            }
        }
        
        return totalWeight;
    }
    
    // Placeholder for the Edge class
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