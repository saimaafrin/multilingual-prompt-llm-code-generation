import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V,E> {
    // Internal maps to store graph data
    private Map<V, Set<E>> outgoingEdges;
    private Map<V, Set<E>> incomingEdges;
    private Map<E, V> edgeSource;
    private Map<E, V> edgeTarget;

    public Graph() {
        outgoingEdges = new HashMap<>();
        incomingEdges = new HashMap<>();
        edgeSource = new HashMap<>();
        edgeTarget = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex  
     * @param e the edge
     */
    public void addEdge(V sourceVertex, V targetVertex, E e) {
        // Add vertices if they don't exist
        if (!outgoingEdges.containsKey(sourceVertex)) {
            outgoingEdges.put(sourceVertex, new HashSet<>());
        }
        if (!incomingEdges.containsKey(targetVertex)) {
            incomingEdges.put(targetVertex, new HashSet<>());
        }

        // Add edge to outgoing edges of source vertex
        outgoingEdges.get(sourceVertex).add(e);

        // Add edge to incoming edges of target vertex  
        incomingEdges.get(targetVertex).add(e);

        // Store edge source and target
        edgeSource.put(e, sourceVertex);
        edgeTarget.put(e, targetVertex);
    }
}