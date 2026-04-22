import org.jgrapht.Graph;
import java.util.Set;

public class CliqueChecker {

    /**
     * Check whether the subgraph of <code>graph</code> induced by the given <code>vertices</code> is complete, i.e. a clique.
     * @param graph the graph.
     * @param vertices the vertices to induce the subgraph from.
     * @return true if the induced subgraph is a clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Iterate over all pairs of vertices
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                // Skip if the vertices are the same
                if (v1.equals(v2)) {
                    continue;
                }
                // Check if there is an edge between v1 and v2
                if (!graph.containsEdge(v1, v2)) {
                    return false;
                }
            }
        }
        return true;
    }
}