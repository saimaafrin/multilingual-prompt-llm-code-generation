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
        // 创建一个映射，将每个顶点映射到自身
        java.util.Map<V, V> vertexMapping = new java.util.HashMap<>();
        for (V vertex : graph.vertexSet()) {
            vertexMapping.put(vertex, vertex);
        }

        // 创建一个映射，将每条边映射到自身
        java.util.Map<E, E> edgeMapping = new java.util.HashMap<>();
        for (E edge : graph.edgeSet()) {
            edgeMapping.put(edge, edge);
        }

        // 返回恒等自同构映射
        return new IsomorphicGraphMapping<>(vertexMapping, edgeMapping, graph, graph);
    }
}