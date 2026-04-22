import org.jgrapht.Graph;
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
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null.");
        }

        // Create a mapping where each vertex maps to itself
        Map<V, V> vertexMap = new HashMap<>();
        for (V vertex : graph.vertexSet()) {
            vertexMap.put(vertex, vertex);
        }

        // Create a mapping where each edge maps to itself
        Map<E, E> edgeMap = new HashMap<>();
        for (E edge : graph.edgeSet()) {
            edgeMap.put(edge, edge);
        }

        // Return an IsomorphicGraphMapping representing the identity automorphism
        return new IsomorphicGraphMapping<>(vertexMap, edgeMap, graph, graph);
    }
}