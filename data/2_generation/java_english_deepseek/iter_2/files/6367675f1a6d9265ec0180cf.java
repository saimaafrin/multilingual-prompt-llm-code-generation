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
        for (V u : vertices) {
            for (V v : vertices) {
                if (!u.equals(v) && !graph.containsEdge(u, v)) {
                    return false;
                }
            }
        }
        return true;
    }
}