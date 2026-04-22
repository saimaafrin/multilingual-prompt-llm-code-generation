import org.jgrapht.Graph;
import java.util.HashMap;
import java.util.Map;

public class GraphAutomorphism {

    /**
     * Computes an identity automorphism (i.e. a self-mapping of a graph in which each vertex also maps to itself).
     * @param graph the input graph
     * @param <V> the graph vertex type
     * @param <E> the graph edge type
     * @return a mapping from graph to graph
     */
    public static <V,E> Map<V,V> getIdentityAutomorphism(Graph<V,E> graph) {
        Map<V,V> mapping = new HashMap<>();
        
        // Map each vertex to itself
        for (V vertex : graph.vertexSet()) {
            mapping.put(vertex, vertex);
        }
        
        return mapping;
    }
}