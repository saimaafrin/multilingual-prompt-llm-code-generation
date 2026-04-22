import java.util.*;

public class Graph<V,E> {
    // 假设图使用邻接表表示
    private Map<V, Map<V, E>> graph = new HashMap<>();
    
    /**
     * 通过遍历边来计算所有具有正度的顶点。这将复杂度保持在 $O(m)$，其中 $m$ 是边的数量。
     * @return 具有正度的顶点集合
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        
        // 遍历所有边
        for (V source : graph.keySet()) {
            Map<V, E> edges = graph.get(source);
            
            // 如果顶点有出边,加入集合
            if (!edges.isEmpty()) {
                visibleVertices.add(source);
            }
            
            // 将所有目标顶点加入集合(它们都有入边)
            visibleVertices.addAll(edges.keySet());
        }
        
        return visibleVertices;
    }
}