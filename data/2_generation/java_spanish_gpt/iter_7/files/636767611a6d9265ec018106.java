import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the edges of the graph
    // This is a placeholder for the actual implementation
    private Set<Edge<V>> getEdges() {
        // Implementation to retrieve edges
        return null;
    }

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        Set<Edge<V>> edges = getEdges();
        
        for (Edge<V> edge : edges) {
            if (v.contains(edge.getTarget())) {
                totalWeight += edge.getWeight();
            }
        }
        
        return totalWeight;
    }
    
    // Placeholder for the Edge class
    private static class Edge<V> {
        private V target;
        private double weight;

        public Edge(V target, double weight) {
            this.target = target;
            this.weight = weight;
        }

        public V getTarget() {
            return target;
        }

        public double getWeight() {
            return weight;
        }
    }
}