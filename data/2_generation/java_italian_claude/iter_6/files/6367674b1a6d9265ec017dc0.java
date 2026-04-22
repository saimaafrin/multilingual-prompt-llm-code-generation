import java.util.*;

public class Graph<V> {
    // Assuming we have a graph representation with edges stored in a Set
    private Set<Edge<V>> edges;
    
    private class Edge<V> {
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
    
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        
        // Iterate through all edges
        for (Edge<V> edge : edges) {
            // Add both source and destination vertices
            visibleVertices.add(edge.getSource());
            visibleVertices.add(edge.getDestination());
        }
        
        return visibleVertices;
    }
}