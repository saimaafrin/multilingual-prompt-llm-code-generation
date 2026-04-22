import java.util.*;

public class MinimalSeparators {
    private Graph<V,E> graph; // Assuming a Graph class with vertices V and edges E
    
    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // Iterate through all edges in the graph
        for (E edge : graph.edgeSet()) {
            // Get endpoints of the edge
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // Get common neighbors of source and target vertices
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborListOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborListOf(target));
            Set<V> commonNeighbors = new HashSet<>(sourceNeighbors);
            commonNeighbors.retainAll(targetNeighbors);
            
            // Compute minimal separators for this edge
            List<Pair<Integer,Integer>> edgeSeparators = new ArrayList<>();
            
            // For each pair of common neighbors
            List<V> commonNeighborsList = new ArrayList<>(commonNeighbors);
            for (int i = 0; i < commonNeighborsList.size(); i++) {
                for (int j = i + 1; j < commonNeighborsList.size(); j++) {
                    V v1 = commonNeighborsList.get(i);
                    V v2 = commonNeighborsList.get(j);
                    
                    // If they form a minimal separator (no subset is a separator)
                    if (isMinimalSeparator(v1, v2, source, target)) {
                        edgeSeparators.add(new Pair<>(
                            graph.getVertexIndex(v1),
                            graph.getVertexIndex(v2)
                        ));
                    }
                }
            }
            
            // Add edge separators to global list
            if (!edgeSeparators.isEmpty()) {
                globalSeparators.add(new Pair<>(edgeSeparators, edge));
            }
        }
        
        return globalSeparators;
    }
    
    // Helper method to check if two vertices form a minimal separator
    private boolean isMinimalSeparator(V v1, V v2, V source, V target) {
        // Remove v1 and v2 from graph temporarily
        graph.removeVertex(v1);
        graph.removeVertex(v2);
        
        // Check if source and target are still connected
        boolean isConnected = hasPath(source, target);
        
        // Restore vertices
        graph.addVertex(v1);
        graph.addVertex(v2);
        
        // If source and target are disconnected, v1,v2 form a separator
        return !isConnected;
    }
    
    // Helper method for path finding between two vertices
    private boolean hasPath(V start, V end) {
        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(end)) {
                return true;
            }
            
            for (V neighbor : graph.neighborListOf(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
}