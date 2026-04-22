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
        // If you want to maintain a directed graph, do not add the edge to targetVertex
        // If it's undirected, you might want to add the reverse edge as well
        // adjacencyList.get(targetVertex).add(e); // Uncomment for undirected graph
    }
}