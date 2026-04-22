import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V,E> {
    
    // Map to store edges between vertices
    private Map<V, Map<V, Set<E>>> index;
    
    public Graph() {
        index = new HashMap<>();
    }
    
    /**
     * Aggiunge un arco all'indice.
     * @param sourceVertex il vertice sorgente 
     * @param targetVertex il vertice di destinazione
     * @param e l'arco
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        // Get or create map for source vertex
        Map<V, Set<E>> sourceMap = index.computeIfAbsent(sourceVertex, k -> new HashMap<>());
        
        // Get or create set of edges between source and target
        Set<E> edges = sourceMap.computeIfAbsent(targetVertex, k -> new HashSet<>());
        
        // Add the edge
        edges.add(e);
    }
}