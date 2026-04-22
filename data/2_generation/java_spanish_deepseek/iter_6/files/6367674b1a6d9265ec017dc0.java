import java.util.*;

public class Graph<V> {
    private Map<V, Set<V>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(V source, V destination) {
        adjacencyList.computeIfAbsent(source, k -> new HashSet<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new HashSet<>()).add(source);
    }

    /**
     * Calcula todos los vértices que tienen un grado positivo iterando sobre las aristas intencionadamente. 
     * Esto mantiene la complejidad en $O(m)$ donde $m$ es el número de aristas.
     * @return conjunto de vértices con grado positivo
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                visibleVertices.add(entry.getKey());
            }
        }
        return visibleVertices;
    }
}