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

    // Método adicional para obtener la arista entre dos vértices
    public E getEdge(V sourceVertex, V targetVertex) {
        if (index.containsKey(sourceVertex)) {
            return index.get(sourceVertex).get(targetVertex);
        }
        return null;
    }
}