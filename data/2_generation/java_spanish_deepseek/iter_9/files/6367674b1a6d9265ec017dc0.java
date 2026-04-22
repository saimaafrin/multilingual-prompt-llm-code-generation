import java.util.HashSet;
import java.util.Set;

/**
 * Calcula todos los vértices que tienen un grado positivo iterando sobre las aristas intencionadamente. 
 * Esto mantiene la complejidad en $O(m)$ donde $m$ es el número de aristas.
 * @return conjunto de vértices con grado positivo
 */
private Set<V> initVisibleVertices() {
    Set<V> visibleVertices = new HashSet<>();
    
    // Suponiendo que 'edges' es una lista de aristas donde cada arista es un par de vértices (V, V)
    for (Edge<V> edge : edges) {
        visibleVertices.add(edge.getSource());
        visibleVertices.add(edge.getTarget());
    }
    
    return visibleVertices;
}

// Clase Edge de ejemplo para representar una arista
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