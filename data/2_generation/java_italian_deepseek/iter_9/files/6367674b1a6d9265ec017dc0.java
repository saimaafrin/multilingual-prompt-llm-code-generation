import java.util.HashSet;
import java.util.Set;

/**
 * Calcola tutti i vertici che hanno un grado positivo iterando intenzionalmente sugli archi. Questo mantiene la complessità a $O(m)$ dove $m$ è il numero di archi.
 * @return insieme di vertici con grado positivo
 */
private Set<V> initVisibleVertices() {
    Set<V> visibleVertices = new HashSet<>();
    
    // Assumiamo che 'edges' sia una lista o collezione di archi disponibile nel contesto
    for (Edge<V> edge : edges) {
        visibleVertices.add(edge.getSource());
        visibleVertices.add(edge.getTarget());
    }
    
    return visibleVertices;
}

// Classe di esempio per rappresentare un arco
class Edge<V> {
    private V source;
    private V target;

    public Edge(V source, V target) {
        this.source = source;
        this.target = target;
    }

    public V getSource() {
        return source;
    }

    public V getTarget() {
        return target;
    }
}