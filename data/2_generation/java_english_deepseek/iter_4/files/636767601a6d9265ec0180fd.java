import java.util.HashMap;
import java.util.Map;

public class Graph<V, E> {
    private Map<V, Map<V, E>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex
     * @param e the edge
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Ensure the source vertex is in the adjacency map
        adjacencyMap.putIfAbsent(sourceVertex, new HashMap<>());
        
        // Add the edge to the adjacency map
        adjacencyMap.get(sourceVertex).put(targetVertex, e);
    }

    // Optional: Method to get the adjacency map for testing or debugging
    public Map<V, Map<V, E>> getAdjacencyMap() {
        return adjacencyMap;
    }
}