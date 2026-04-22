import java.util.HashSet;
import java.util.Set;

/**
 * Calcula todos los vértices que tienen un grado positivo iterando sobre las aristas intencionadamente. 
 * Esto mantiene la complejidad en $O(m)$ donde $m$ es el número de aristas.
 * @return conjunto de vértices con grado positivo
 */
private Set<V> initVisibleVertices() {
    Set<V> visibleVertices = new HashSet<>();
    
    // Suponiendo que 'edges' es una lista de aristas disponibles en el contexto
    for (Edge<V> edge : edges) {
        visibleVertices.add(edge.getSource());
        visibleVertices.add(edge.getDestination());
    }
    
    return visibleVertices;
}

// Clase Edge de ejemplo para representar una arista
class Edge<V> {
    private V source;
    private V destination;

    public Edge(V source, V destination) {
        this.source = source;
        this.destination = destination;
    }

    public V getSource() {
        return source;
    }

    public V getDestination() {
        return destination;
    }
}