import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V,E> {
    // Maps vertices to their adjacent edges
    private Map<V, Set<E>> vertexMap;

    public Graph() {
        vertexMap = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex  
     * @param targetVertex the target vertex
     * @param e the edge
     */
    public void addEdge(V sourceVertex, V targetVertex, E e) {
        // Create sets for vertices if they don't exist
        vertexMap.putIfAbsent(sourceVertex, new HashSet<>());
        vertexMap.putIfAbsent(targetVertex, new HashSet<>());

        // Add edge to source vertex's edge set
        vertexMap.get(sourceVertex).add(e);
    }
}