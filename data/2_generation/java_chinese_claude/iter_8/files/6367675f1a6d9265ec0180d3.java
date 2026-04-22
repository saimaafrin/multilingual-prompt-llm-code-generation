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
        Map<V,V> forwardMapping = new HashMap<>();
        Map<V,V> backwardMapping = new HashMap<>();
        
        // 对每个顶点映射到自身
        for(V vertex : graph.vertexSet()) {
            forwardMapping.put(vertex, vertex);
            backwardMapping.put(vertex, vertex);
        }
        
        // 创建并返回同构映射
        return new IsomorphicGraphMapping<>(
            graph,  // 源图
            graph,  // 目标图
            forwardMapping,  // 正向映射
            backwardMapping  // 反向映射
        );
    }
}