import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;

public class GraphUtils {

    /**
     * 检查由给定的 <code>vertices</code> 诱导的 <code>graph</code> 的子图是否为完全图，即一个团。
     * @param graph 图。
     * @param vertices 用于诱导子图的顶点。
     * @return 如果诱导的子图是一个团，则返回真。
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // 如果顶点集合为空或只有一个顶点，则是一个团
        if (vertices.isEmpty() || vertices.size() == 1) {
            return true;
        }

        // 检查每对顶点是否都有边相连
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // 如果有一对顶点没有边相连，则不是团
                }
            }
        }
        return true; // 所有顶点对都有边相连，是一个团
    }
}