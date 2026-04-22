import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V, E> {
    private Map<V, Set<E>> index;

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
        index.putIfAbsent(sourceVertex, new HashSet<>());
        index.putIfAbsent(targetVertex, new HashSet<>());
        
        index.get(sourceVertex).add(e);
        index.get(targetVertex).add(e);
    }
}