import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

import java.util.HashMap;
import java.util.Map;

public class GraphUtils {

    /**
     * Computes an identity automorphism (i.e. a self-mapping of a graph in which each vertex also maps to itself).
     * @param graph the input graph
     * @param <V> the graph vertex type
     * @param <E> the graph edge type
     * @return a mapping from graph to graph
     */
    public static <V,E> IsomorphicGraphMapping<V,E> identity(Graph<V,E> graph) {
        // Create mappings where each vertex maps to itself
        Map<V,V> forwardMapping = new HashMap<>();
        Map<V,V> backwardMapping = new HashMap<>();
        
        for (V vertex : graph.vertexSet()) {
            forwardMapping.put(vertex, vertex);
            backwardMapping.put(vertex, vertex);
        }

        return new IsomorphicGraphMapping<>(
            graph,      // First graph
            graph,      // Second graph (same as first for automorphism)
            forwardMapping,
            backwardMapping
        );
    }
}