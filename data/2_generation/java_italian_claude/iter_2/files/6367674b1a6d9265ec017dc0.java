import java.util.*;

public class Graph<V> {
    // Assuming we have a graph representation with edges stored in a set
    private Set<Edge<V>> edges;
    
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        
        // Iterate through all edges and add both vertices of each edge
        for (Edge<V> edge : edges) {
            visibleVertices.add(edge.getSource());
            visibleVertices.add(edge.getTarget());
        }
        
        return visibleVertices;
    }
    
    // Helper Edge class
    private static class Edge<V> {
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
}