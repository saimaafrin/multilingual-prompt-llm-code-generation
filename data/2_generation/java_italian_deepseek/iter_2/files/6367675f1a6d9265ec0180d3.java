import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

public class GraphUtils {

    /**
     * Calcola un automorfismo identitario (cioè una mappatura di un grafo in cui ogni vertice si mappa su se stesso).
     * @param graph il grafo di input
     * @param <V> il tipo di vertice del grafo
     * @param <E> il tipo di arco del grafo
     * @return una mappatura da grafo a grafo
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        // Creiamo una mappatura identitaria, dove ogni vertice è mappato su se stesso
        IsomorphicGraphMapping<V, E> mapping = new IsomorphicGraphMapping<>(graph, graph);
        for (V vertex : graph.vertexSet()) {
            mapping.addVertexMapping(vertex, vertex);
        }
        return mapping;
    }
}