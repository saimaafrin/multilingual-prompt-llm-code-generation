import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

import java.util.HashMap;
import java.util.Map;

public class GraphUtils {

    /**
     * Calcola un automorfismo identitario (cioè una mappatura di un grafo in cui ogni vertice si mappa su se stesso).
     * @param graph il grafo di input
     * @param <V> il tipo di vertice del grafo
     * @param <E> il tipo di arco del grafo
     * @return una mappatura da grafo a grafo
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        Map<V, V> vertexMap = new HashMap<>();
        Map<E, E> edgeMap = new HashMap<>();

        // Mappa ogni vertice su se stesso
        for (V vertex : graph.vertexSet()) {
            vertexMap.put(vertex, vertex);
        }

        // Mappa ogni arco su se stesso
        for (E edge : graph.edgeSet()) {
            edgeMap.put(edge, edge);
        }

        return new IsomorphicGraphMapping<>(vertexMap, edgeMap, graph, graph);
    }
}