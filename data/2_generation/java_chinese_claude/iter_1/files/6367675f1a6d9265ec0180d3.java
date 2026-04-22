import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.graph.AsGraphUnion;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;
import java.util.HashMap;
import java.util.Map;

public class GraphUtils {

    /**
     * 计算一个恒等自同构（即图的自映射，其中每个顶点也映射到自身）。
     * @param graph 输入图
     * @param <V> 图的顶点类型
     * @param <E> 图的边类型
     * @return 从图到图的映射
     */
    public static <V,E> IsomorphicGraphMapping<V,E> identity(Graph<V,E> graph) {
        // 创建顶点映射
        Map<V,V> vertexMap = new HashMap<>();
        
        // 将每个顶点映射到自身
        for(V vertex : graph.vertexSet()) {
            vertexMap.put(vertex, vertex);
        }
        
        // 创建边映射
        Map<E,E> edgeMap = new HashMap<>();
        
        // 将每条边映射到自身
        for(E edge : graph.edgeSet()) {
            edgeMap.put(edge, edge);
        }
        
        // 返回恒等映射
        return new IsomorphicGraphMapping<>(
            graph,  // 源图
            graph,  // 目标图
            vertexMap, // 顶点映射
            vertexMap, // 顶点反向映射
            edgeMap,   // 边映射
            edgeMap    // 边反向映射
        );
    }
}