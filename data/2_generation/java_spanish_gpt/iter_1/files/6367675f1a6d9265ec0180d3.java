import java.util.HashMap;
import java.util.Map;

public class GraphUtils {

    /** 
     * Calcula un automorfismo de identidad (es decir, un mapeo propio de un grafo en el que cada vértice también se mapea a sí mismo).
     * @param graph el grafo de entrada
     * @param <V> el tipo de vértice del grafo
     * @param <E> el tipo de arista del grafo
     * @return un mapeo de grafo a grafo
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identidad(Graph<V, E> grafo) {
        Map<V, V> mapping = new HashMap<>();
        
        for (V vertex : grafo.getVertices()) {
            mapping.put(vertex, vertex); // Mapeo de cada vértice a sí mismo
        }
        
        return new IsomorphicGraphMapping<>(mapping);
    }
}

class Graph<V, E> {
    // Implementación del grafo
    public Iterable<V> getVertices() {
        // Retornar los vértices del grafo
        return null; // Placeholder
    }
}

class IsomorphicGraphMapping<V, E> {
    private final Map<V, V> mapping;

    public IsomorphicGraphMapping(Map<V, V> mapping) {
        this.mapping = mapping;
    }

    public Map<V, V> getMapping() {
        return mapping;
    }
}