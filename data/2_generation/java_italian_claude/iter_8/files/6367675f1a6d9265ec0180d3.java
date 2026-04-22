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
        Map<V,V> vertexCorrespondence = new HashMap<>();
        Map<E,E> edgeCorrespondence = new HashMap<>();
        
        // Map each vertex to itself
        for(V vertex : graph.vertexSet()) {
            vertexCorrespondence.put(vertex, vertex);
        }
        
        // Map each edge to itself
        for(E edge : graph.edgeSet()) {
            edgeCorrespondence.put(edge, edge);
        }
        
        // Create and return the isomorphic mapping
        return new IsomorphicGraphMapping<>(
            graph, // Graph 1 
            graph, // Graph 2 (same graph)
            vertexCorrespondence,
            edgeCorrespondence
        );
    }
}