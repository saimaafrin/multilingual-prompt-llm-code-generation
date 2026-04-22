import java.util.Set;

public class Graph<V> {
    
    // Assuming a method to get incoming edges for a vertex
    private Set<Edge<V>> getIncomingEdges(V vertex) {
        // Implementation to retrieve incoming edges for the vertex
        return null; // Placeholder
    }

    // Assuming a method to get the weight of an edge
    private double getEdgeWeight(Edge<V> edge) {
        // Implementation to retrieve the weight of the edge
        return 0.0; // Placeholder
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
                totalWeight += getEdgeWeight(edge);
            }
        }
        return totalWeight;
    }
    
    // Placeholder for Edge class
    private static class Edge<V> {
        // Edge implementation
    }
}