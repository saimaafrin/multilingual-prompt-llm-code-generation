import java.util.*;

public class Graph<V,E> {

    // Assume these instance variables exist
    private Map<V, Set<E>> vertexMap; // Maps vertices to their incident edges
    private Map<E, V[]> edgeMap; // Maps edges to their endpoint vertices

    /**
     * Compute all vertices that have positive degree by iterating over the edges on purpose. 
     * This keeps the complexity to O(m) where m is the number of edges.
     * @return set of vertices with positive degree
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        
        // Iterate through all edges
        for (E edge : edgeMap.keySet()) {
            // Get the vertices connected by this edge
            V[] endpoints = edgeMap.get(edge);
            
            // Add both endpoints to the visible vertices set
            visibleVertices.add(endpoints[0]);
            visibleVertices.add(endpoints[1]);
        }
        
        return visibleVertices;
    }
}