import org.jgrapht.Graph;
import java.util.Set;

public class GraphUtils {
    /**
     * Check whether the subgraph of <code>graph</code> induced by the given <code>vertices</code> is complete, i.e. a clique.
     * @param graph the graph.
     * @param vertices the vertices to induce the subgraph from.
     * @return true if the induced subgraph is a clique.
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        // For a complete graph, each vertex must connect to all other vertices
        // Number of edges should be n*(n-1)/2 where n is number of vertices
        
        for (V vertex1 : vertices) {
            for (V vertex2 : vertices) {
                if (!vertex1.equals(vertex2)) {
                    // Check if edge exists between vertices
                    if (!graph.containsEdge(vertex1, vertex2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}