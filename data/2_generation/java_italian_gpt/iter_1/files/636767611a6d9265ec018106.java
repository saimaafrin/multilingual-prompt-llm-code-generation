import java.util.Set;

public class Graph<V> {
    
    // Assuming a method to get the incoming edges for a vertex
    private Set<Edge<V>> getIncomingEdges(V vertex) {
        // Implementation to retrieve incoming edges for the vertex
        return null; // Placeholder
    }

    // Assuming an Edge class that has a method to get the weight
    private static class Edge<V> {
        private double weight;

        public Edge(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }
    }

    /** 
     * Calcola la somma dei pesi che entrano in un vertice
     * @param v il vertice
     * @return la somma dei pesi che entrano in un vertice
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (V vertex : v) {
            Set<Edge<V>> incomingEdges = getIncomingEdges(vertex);
            for (Edge<V> edge : incomingEdges) {
                totalWeight += edge.getWeight();
            }
        }
        return totalWeight;
    }
}