import java.util.Set;

public class Graph<V> {
    
    // Assuming there's a method to get the incoming edges for a vertex
    private double getIncomingWeight(V vertex) {
        // Placeholder for actual implementation
        return 0.0;
    }

    /** 
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (V vertex : v) {
            totalWeight += getIncomingWeight(vertex);
        }
        return totalWeight;
    }
}