import java.util.HashMap;
import java.util.Map;

public class GraphIndex<V, E> {
    private Map<V, Map<V, E>> index;

    public GraphIndex() {
        index = new HashMap<>();
    }

    /**
     * Agrega una arista al índice.
     * @param sourceVertex el vértice fuente
     * @param targetVertex el vértice objetivo
     * @param e la arista
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        if (!index.containsKey(sourceVertex)) {
            index.put(sourceVertex, new HashMap<>());
        }
        index.get(sourceVertex).put(targetVertex, e);
    }
}