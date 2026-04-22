import java.util.*;

public class Graph<V,E> {

    // 存储顶点到边的映射关系
    private Map<V, Map<V, E>> index;

    public Graph() {
        index = new HashMap<>();
    }

    /**
     * 将边添加到索引中。
     * @param sourceVertex 源顶点
     * @param targetVertex 目标顶点 
     * @param e 边
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // 获取源顶点的边映射,如果不存在则创建新的
        Map<V, E> edges = index.computeIfAbsent(sourceVertex, k -> new HashMap<>());
        
        // 将目标顶点和边添加到映射中
        edges.put(targetVertex, e);
    }
}