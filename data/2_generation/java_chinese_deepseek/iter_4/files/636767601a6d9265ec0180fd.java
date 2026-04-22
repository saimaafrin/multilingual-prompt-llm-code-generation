import java.util.HashMap;
import java.util.Map;

public class GraphIndex<V, E> {
    private Map<V, Map<V, E>> index;

    public GraphIndex() {
        index = new HashMap<>();
    }

    /**
     * 将边添加到索引中。
     * @param sourceVertex 源顶点
     * @param targetVertex 目标顶点
     * @param e 边
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        if (!index.containsKey(sourceVertex)) {
            index.put(sourceVertex, new HashMap<>());
        }
        index.get(sourceVertex).put(targetVertex, e);
    }

    // Optional: Method to retrieve an edge from the index
    public E getEdge(V sourceVertex, V targetVertex) {
        if (index.containsKey(sourceVertex)) {
            return index.get(sourceVertex).get(targetVertex);
        }
        return null;
    }
}