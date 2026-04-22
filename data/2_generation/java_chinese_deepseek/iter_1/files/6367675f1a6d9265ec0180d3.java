import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

import java.util.HashMap;
import java.util.Map;

public class GraphIdentity {

    /**
     * 计算一个恒等自同构（即图的自映射，其中每个顶点也映射到自身）。
     * @param graph 输入图
     * @param <V> 图的顶点类型
     * @param <E> 图的边类型
     * @return 从图到图的映射
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        Map<V, V> vertexMap = new HashMap<>();
        Map<E, E> edgeMap = new HashMap<>();

        // 创建顶点映射
        for (V vertex : graph.vertexSet()) {
            vertexMap.put(vertex, vertex);
        }

        // 创建边映射
        for (E edge : graph.edgeSet()) {
            edgeMap.put(edge, edge);
        }

        return new IsomorphicGraphMapping<>(vertexMap, edgeMap, graph, graph);
    }
}