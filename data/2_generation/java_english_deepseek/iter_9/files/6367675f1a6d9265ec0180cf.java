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
        for (V u : vertices) {
            for (V v : vertices) {
                // Skip if u and v are the same vertex
                if (u.equals(v)) {
                    continue;
                }
                // Check if there is no edge between u and v
                if (!graph.containsEdge(u, v)) {
                    return false;
                }
            }
        }
        // If all pairs are connected, it's a clique
        return true;
    }
}