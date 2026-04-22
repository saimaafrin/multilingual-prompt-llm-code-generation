import java.util.*;

public class Graph<V,E> {
    // 假设图使用邻接表表示
    private Map<V, Map<V, E>> graph = new HashMap<>();
    
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        
        // 遍历所有边来找到具有正度的顶点
        for(V vertex : graph.keySet()) {
            Map<V, E> edges = graph.get(vertex);
            if(edges != null && !edges.isEmpty()) {
                // 如果顶点有出边,加入集合
                visibleVertices.add(vertex);
                // 将所有邻接点也加入集合(它们有入边)
                visibleVertices.addAll(edges.keySet());
            }
        }
        
        return visibleVertices;
    }
}