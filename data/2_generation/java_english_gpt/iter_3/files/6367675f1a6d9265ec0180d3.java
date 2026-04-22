import java.util.HashMap;
import java.util.Map;

class Graph<V, E> {
    // Assume this class has necessary methods and properties for a graph
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

public class GraphUtils {
    /** 
     * Computes an identity automorphism (i.e. a self-mapping of a graph in which each vertex also maps to itself).
     * @param graph the input graph
     * @param <V> the graph vertex type
     * @param <E> the graph edge type
     * @return a mapping from graph to graph
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        Map<V, V> mapping = new HashMap<>();
        
        // Assuming the graph has a method to get all vertices
        for (V vertex : graph.getVertices()) {
            mapping.put(vertex, vertex);
        }
        
        return new IsomorphicGraphMapping<>(mapping);
    }
}