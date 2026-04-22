import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V, E> {
    private Map<V, Set<E>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /** 
     * 将边添加到索引中。
     * @param sourceVertex 源顶点
     * @param targetVertex 目标顶点
     * @param e 边
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        adjacencyList.putIfAbsent(sourceVertex, new HashSet<>());
        adjacencyList.putIfAbsent(targetVertex, new HashSet<>());
        
        adjacencyList.get(sourceVertex).add(e);
        // If you want to maintain a directed graph, do not add the edge to targetVertex
        // If you want to maintain an undirected graph, you can add the edge to targetVertex as well
        // adjacencyList.get(targetVertex).add(e);
    }
}