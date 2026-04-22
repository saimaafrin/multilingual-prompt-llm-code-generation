import org.jgrapht.Graph;
import java.util.Set;

public class GraphUtils {
    /**
     * 检查由给定的 <code>vertices</code> 诱导的 <code>graph</code> 的子图是否为完全图，即一个团。
     * @param graph 图。
     * @param vertices 用于诱导子图的顶点。
     * @return 如果诱导的子图是一个团，则返回真。
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        // 对于团中的每对顶点,它们之间都必须有边相连
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2)) { // 不需要检查顶点自身
                    if (!graph.containsEdge(v1, v2)) {
                        return false; // 如果任意两点间没有边,则不是团
                    }
                }
            }
        }
        return true; // 所有点对之间都有边,是一个团
    }
}