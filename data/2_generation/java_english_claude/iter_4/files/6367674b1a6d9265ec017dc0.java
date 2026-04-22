import java.util.*;

public class Graph<V> {
    // Assume graph is represented as adjacency list
    private Map<V, Set<V>> adjacencyList;

    private Set<V> initVisibleVertices() {
        Set<V> verticesWithEdges = new HashSet<>();
        
        // Iterate through all edges in adjacency list
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            V vertex = entry.getKey();
            Set<V> neighbors = entry.getValue();
            
            // If vertex has any edges, add it to result set
            if (!neighbors.isEmpty()) {
                verticesWithEdges.add(vertex);
                // Also add all neighbors since they must have at least one edge
                verticesWithEdges.addAll(neighbors);
            }
        }
        
        return verticesWithEdges;
    }
}