import java.util.*;

public class Graph<V,E> {
    // Internal map to store adjacency lists
    private Map<V, List<Edge<V,E>>> adjacencyMap;
    
    // Edge class to store edge information
    private static class Edge<V,E> {
        private V source;
        private V target;
        private E data;
        
        public Edge(V source, V target, E data) {
            this.source = source;
            this.target = target;
            this.data = data;
        }
    }
    
    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex  
     * @param e the edge
     */
    public void addEdge(V sourceVertex, V targetVertex, E e) {
        // Create new edge
        Edge<V,E> edge = new Edge<>(sourceVertex, targetVertex, e);
        
        // Add source vertex if it doesn't exist
        adjacencyMap.putIfAbsent(sourceVertex, new ArrayList<>());
        
        // Add target vertex if it doesn't exist
        adjacencyMap.putIfAbsent(targetVertex, new ArrayList<>());
        
        // Add edge to source vertex's adjacency list
        adjacencyMap.get(sourceVertex).add(edge);
    }
}