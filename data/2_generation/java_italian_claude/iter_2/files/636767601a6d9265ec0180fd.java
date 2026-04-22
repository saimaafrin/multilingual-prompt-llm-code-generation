import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V,E> {
    
    // Maps to store vertex and edge relationships
    private Map<V, Set<E>> sourceVertexToEdgeMap;
    private Map<V, Set<E>> targetVertexToEdgeMap;
    private Map<E, V> edgeToSourceVertexMap;
    private Map<E, V> edgeToTargetVertexMap;

    public Graph() {
        sourceVertexToEdgeMap = new HashMap<>();
        targetVertexToEdgeMap = new HashMap<>();
        edgeToSourceVertexMap = new HashMap<>();
        edgeToTargetVertexMap = new HashMap<>();
    }

    /**
     * Aggiunge un arco all'indice.
     * @param sourceVertex il vertice sorgente
     * @param targetVertex il vertice di destinazione
     * @param e l'arco
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Add edge to source vertex map
        sourceVertexToEdgeMap.computeIfAbsent(sourceVertex, k -> new HashSet<>()).add(e);
        
        // Add edge to target vertex map
        targetVertexToEdgeMap.computeIfAbsent(targetVertex, k -> new HashSet<>()).add(e);
        
        // Map edge to its source and target vertices
        edgeToSourceVertexMap.put(e, sourceVertex);
        edgeToTargetVertexMap.put(e, targetVertex);
    }
}