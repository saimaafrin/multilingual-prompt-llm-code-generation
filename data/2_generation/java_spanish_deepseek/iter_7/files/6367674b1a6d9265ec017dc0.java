import java.util.*;

public class Graph<V> {
    private Map<V, Set<V>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Calcula todos los vértices que tienen un grado positivo iterando sobre las aristas intencionadamente. 
     * Esto mantiene la complejidad en $O(m)$ donde $m$ es el número de aristas.
     * @return conjunto de vértices con grado positivo
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            V vertex = entry.getKey();
            Set<V> neighbors = entry.getValue();
            if (!neighbors.isEmpty()) {
                visibleVertices.add(vertex);
            }
            visibleVertices.addAll(neighbors);
        }
        return visibleVertices;
    }

    // Other methods for adding vertices and edges would go here
}