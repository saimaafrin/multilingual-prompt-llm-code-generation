import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V,E> {
    
    // Index maps to store edges
    private Map<V, Map<V, Set<E>>> outgoingEdges;
    private Map<V, Map<V, Set<E>>> incomingEdges;

    public Graph() {
        outgoingEdges = new HashMap<>();
        incomingEdges = new HashMap<>();
    }

    /**
     * Aggiunge un arco all'indice.
     * @param sourceVertex il vertice sorgente 
     * @param targetVertex il vertice di destinazione
     * @param e l'arco
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Add to outgoing edges
        if (!outgoingEdges.containsKey(sourceVertex)) {
            outgoingEdges.put(sourceVertex, new HashMap<>());
        }
        if (!outgoingEdges.get(sourceVertex).containsKey(targetVertex)) {
            outgoingEdges.get(sourceVertex).put(targetVertex, new HashSet<>());
        }
        outgoingEdges.get(sourceVertex).get(targetVertex).add(e);

        // Add to incoming edges
        if (!incomingEdges.containsKey(targetVertex)) {
            incomingEdges.put(targetVertex, new HashMap<>());
        }
        if (!incomingEdges.get(targetVertex).containsKey(sourceVertex)) {
            incomingEdges.get(targetVertex).put(sourceVertex, new HashSet<>());
        }
        incomingEdges.get(targetVertex).get(sourceVertex).add(e);
    }
}