import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.graph.DefaultGraphMapping;
import org.jgrapht.graph.SimpleGraph;
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
        Map<V,V> vertexMap = new HashMap<>();
        Map<E,E> edgeMap = new HashMap<>();
        
        // Map each vertex to itself
        for (V vertex : graph.vertexSet()) {
            vertexMap.put(vertex, vertex);
        }
        
        // Map each edge to itself
        for (E edge : graph.edgeSet()) {
            edgeMap.put(edge, edge);
        }
        
        return new IsomorphicGraphMapping<>(graph, graph, vertexMap, edgeMap);
    }
}