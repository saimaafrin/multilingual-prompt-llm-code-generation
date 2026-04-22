import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

public class GraphUtils {

    /**
     * 计算一个恒等自同构（即图的自映射，其中每个顶点也映射到自身）。
     * @param graph 输入图
     * @param <V> 图的顶点类型
     * @param <E> 图的边类型
     * @return 从图到图的映射
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        return new IsomorphicGraphMapping<>(graph, graph, v -> v, e -> e);
    }
}