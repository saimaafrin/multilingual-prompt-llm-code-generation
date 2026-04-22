import java.util.*;

public class Graph<V,E> {

    // Internal map to store vertex-edge relationships
    private Map<V, Map<V, E>> index;

    public Graph() {
        index = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex  
     * @param e the edge
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Get or create map for source vertex
        Map<V, E> connections = index.computeIfAbsent(sourceVertex, k -> new HashMap<>());
        
        // Add edge between source and target
        connections.put(targetVertex, e);
    }
}