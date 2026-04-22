import java.util.*;

public class Graph<V,E> {

    // Graph representation using adjacency lists
    private Map<V, List<Edge<V,E>>> adjacencyMap;

    private class Edge<V,E> {
        private V source;
        private V target; 
        private E data;
        
        public Edge(V source, V target, E data) {
            this.source = source;
            this.target = target;
            this.data = data;
        }
    }

    /** 
     * Calcula todos los vértices que tienen un grado positivo iterando sobre las aristas intencionadamente. 
     * Esto mantiene la complejidad en O(m) donde m es el número de aristas.
     * @return conjunto de vértices con grado positivo
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        
        // Iterate through all vertices and their edges
        for (Map.Entry<V, List<Edge<V,E>>> entry : adjacencyMap.entrySet()) {
            V vertex = entry.getKey();
            List<Edge<V,E>> edges = entry.getValue();
            
            // If vertex has any edges, add it to visible set
            if (!edges.isEmpty()) {
                visibleVertices.add(vertex);
                
                // Also add all target vertices of the edges
                for (Edge<V,E> edge : edges) {
                    visibleVertices.add(edge.target);
                }
            }
        }
        
        return visibleVertices;
    }
}