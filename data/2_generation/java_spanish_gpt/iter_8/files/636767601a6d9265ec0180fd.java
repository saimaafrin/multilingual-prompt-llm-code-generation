import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V, E> {
    private Map<V, Set<E>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /** 
     * Agrega una arista al índice.
     * @param sourceVertex el vértice fuente
     * @param targetVertex el vértice objetivo
     * @param e la arista
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        adjacencyList.putIfAbsent(sourceVertex, new HashSet<>());
        adjacencyList.putIfAbsent(targetVertex, new HashSet<>());
        
        adjacencyList.get(sourceVertex).add(e);
        // If needed, you can also maintain a reverse mapping for the target vertex
        // adjacencyList.get(targetVertex).add(e); // Uncomment if bidirectional edges are needed
    }
}