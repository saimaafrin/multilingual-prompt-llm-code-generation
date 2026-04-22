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
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && graph.getEdge(v1, v2) == null) {
                    return false; // If there is no edge between any two distinct vertices, it's not a clique
                }
            }
        }
        return true; // All pairs of vertices are connected
    }
}