import java.util.Set;
import java.util.Map;

public class Graph<V,E> {
    
    private Map<V, Map<V,E>> graph;
    
    /**
     * Calcula la suma de los pesos que entran a un vértice
     * @param v el vértice
     * @return la suma de los pesos que entran a un vértice
     */
    public double vertexWeight(Set<V> v) {
        double sum = 0.0;
        
        // Para cada vértice en el conjunto v
        for(V vertex : v) {
            // Para cada vértice origen en el grafo
            for(Map.Entry<V, Map<V,E>> entry : graph.entrySet()) {
                V source = entry.getKey();
                Map<V,E> edges = entry.getValue();
                
                // Si existe una arista hacia el vértice actual
                if(edges.containsKey(vertex)) {
                    // Suma el peso de la arista
                    E edge = edges.get(vertex);
                    if(edge instanceof Number) {
                        sum += ((Number)edge).doubleValue();
                    }
                }
            }
        }
        
        return sum;
    }
}