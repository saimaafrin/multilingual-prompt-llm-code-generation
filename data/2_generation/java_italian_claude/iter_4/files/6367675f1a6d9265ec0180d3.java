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
        // Create identity mappings for vertices and edges
        Map<V,V> vertexCorr = new HashMap<>();
        Map<E,E> edgeCorr = new HashMap<>();
        
        // Map each vertex to itself
        for(V vertex : graph.vertexSet()) {
            vertexCorr.put(vertex, vertex);
        }
        
        // Map each edge to itself
        for(E edge : graph.edgeSet()) {
            edgeCorr.put(edge, edge);
        }
        
        // Create and return the isomorphic mapping
        return new IsomorphicGraphMapping<>(
            graph, // source graph
            graph, // target graph (same as source for identity mapping)
            vertexCorr,
            vertexCorr, // inverse vertex correspondence is the same for identity
            edgeCorr,
            edgeCorr  // inverse edge correspondence is the same for identity
        );
    }
}