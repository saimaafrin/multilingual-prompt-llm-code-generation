import java.util.HashMap;
import java.util.Map;

public class GraphIndex<V, E> {
    private Map<V, Map<V, E>> index;

    public GraphIndex() {
        index = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex
     * @param e the edge
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