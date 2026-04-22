import org.jgrapht.Graph;
import java.util.Set;

public class CliqueChecker {

    /**
     * 检查由给定的 <code>vertices</code> 诱导的 <code>graph</code> 的子图是否为完全图，即一个团。
     * @param graph 图。
     * @param vertices 用于诱导子图的顶点。
     * @return 如果诱导的子图是一个团，则返回真。
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // 遍历所有顶点对
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    // 如果存在一对顶点之间没有边，则不是团
                    return false;
                }
            }
        }
        // 所有顶点对之间都有边，是团
        return true;
    }
}