import org.jgrapht.Graph;
import java.util.Set;

public class GraphUtils {

    /**
     * 检查由给定的 <code>vertices</code> 诱导的 <code>graph</code> 的子图是否为完全图，即一个团。
     * @param graph 图。
     * @param vertices 用于诱导子图的顶点。
     * @return 如果诱导的子图是一个团，则返回真。
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        int vertexCount = vertices.size();
        if (vertexCount < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        // Check if every pair of vertices in the set is connected
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // Found a pair that is not connected
                }
            }
        }
        return true; // All pairs are connected
    }
}