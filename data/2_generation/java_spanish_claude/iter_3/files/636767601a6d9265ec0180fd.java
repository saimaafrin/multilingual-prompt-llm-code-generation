import java.util.*;

public class Graph<V,E> {

    // Map to store edges indexed by source and target vertices
    protected Map<V, Map<V, List<E>>> index;

    public Graph() {
        index = new HashMap<>();
    }

    /**
     * Agrega una arista al índice.
     * @param sourceVertex el vértice fuente 
     * @param targetVertex el vértice objetivo
     * @param e la arista
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Get or create map for source vertex
        Map<V, List<E>> sourceMap = index.computeIfAbsent(sourceVertex, k -> new HashMap<>());
        
        // Get or create list of edges for target vertex
        List<E> edgeList = sourceMap.computeIfAbsent(targetVertex, k -> new ArrayList<>());
        
        // Add edge to list
        edgeList.add(e);
    }
}