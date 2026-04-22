import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get incoming edges for a vertex
    // This is a placeholder for the actual edge representation
    private class Edge {
        V from;
        V to;
        double weight;

        Edge(V from, V to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    // Placeholder for the graph's edges
    private Set<Edge> edges;

    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (Edge edge : edges) {
            if (v.contains(edge.to)) {
                totalWeight += edge.weight;
            }
        }
        return totalWeight;
    }
}