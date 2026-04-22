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
        // Create vertex mapping where each vertex maps to itself
        Map<V,V> vertexCorrespondence = new HashMap<>();
        for (V vertex : graph.vertexSet()) {
            vertexCorrespondence.put(vertex, vertex);
        }

        // Create edge mapping where each edge maps to itself
        Map<E,E> edgeCorrespondence = new HashMap<>();
        for (E edge : graph.edgeSet()) {
            edgeCorrespondence.put(edge, edge);
        }

        return new IsomorphicGraphMapping<>(
            graph, // Graph 1 (source)
            graph, // Graph 2 (target) - same as source for identity mapping
            vertexCorrespondence,
            edgeCorrespondence
        );
    }
}