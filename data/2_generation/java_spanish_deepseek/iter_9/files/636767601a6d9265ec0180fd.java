import java.util.HashMap;
import java.util.Map;

public class Graph<V, E> {
    private Map<V, Map<V, E>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * Agrega una arista al índice.
     * @param sourceVertex el vértice fuente
     * @param targetVertex el vértice objetivo
     * @param e la arista
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        if (!adjacencyMap.containsKey(sourceVertex)) {
            adjacencyMap.put(sourceVertex, new HashMap<>());
        }
        adjacencyMap.get(sourceVertex).put(targetVertex, e);
    }

    // Other methods of the Graph class can be added here
}