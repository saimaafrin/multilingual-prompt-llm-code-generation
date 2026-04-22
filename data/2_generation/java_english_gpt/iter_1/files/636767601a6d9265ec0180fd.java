import java.util.HashMap;
import java.util.Map;

public class Graph<V, E> {
    private Map<V, Map<V, E>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /** 
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex
     * @param e the edge
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        adjacencyList.putIfAbsent(sourceVertex, new HashMap<>());
        adjacencyList.get(sourceVertex).put(targetVertex, e);
    }
}