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
            List<V> neighborList = new ArrayList<>(commonNeighbors);
            for (int i = 0; i < neighborList.size(); i++) {
                for (int j = i + 1; j < neighborList.size(); j++) {
                    V v1 = neighborList.get(i);
                    V v2 = neighborList.get(j);
                    
                    // Check if {v1,v2} forms a minimal separator
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
        Set<V> separator = new HashSet<>();
        separator.add(v1);
        separator.add(v2);
        
        // Check if source and target are in different components after removal
        Set<V> visited = new HashSet<>();
        visited.addAll(separator);
        
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        
        boolean targetFound = false;
        while (!queue.isEmpty() && !targetFound) {
            V current = queue.poll();
            for (V neighbor : graph.neighborListOf(current)) {
                if (!visited.contains(neighbor)) {
                    if (neighbor.equals(target)) {
                        targetFound = true;
                        break;
                    }
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        // If target not found, v1 and v2 form a separator
        return !targetFound;
    }
}