import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.graph.AsGraphUnion;
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
    public static <V,E> IsomorphicGraphMapping<V,E> identity(Graph<V,E> graph) {
        Map<V,V> forwardMapping = new HashMap<>();
        Map<V,V> backwardMapping = new HashMap<>();
        
        // Map each vertex to itself
        for(V vertex : graph.vertexSet()) {
            forwardMapping.put(vertex, vertex);
            backwardMapping.put(vertex, vertex);
        }

        return new IsomorphicGraphMapping<>(
            graph, // source graph
            graph, // target graph 
            forwardMapping,
            backwardMapping
        );
    }
}