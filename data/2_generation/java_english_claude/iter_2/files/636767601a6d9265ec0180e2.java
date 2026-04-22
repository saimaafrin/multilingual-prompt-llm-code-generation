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
            
            // Get common neighbors of the endpoints
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborListOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborListOf(target));
            Set<V> commonNeighbors = new HashSet<>(sourceNeighbors);
            commonNeighbors.retainAll(targetNeighbors);
            
            // For each common neighbor pair, check if they form a minimal separator
            List<Pair<Integer,Integer>> edgeSeparators = new ArrayList<>();
            List<V> neighborList = new ArrayList<>(commonNeighbors);
            
            for (int i = 0; i < neighborList.size(); i++) {
                for (int j = i + 1; j < neighborList.size(); j++) {
                    V v1 = neighborList.get(i);
                    V v2 = neighborList.get(j);
                    
                    // Check if {v1,v2} is a minimal separator
                    Set<V> separator = new HashSet<>();
                    separator.add(v1);
                    separator.add(v2);
                    
                    if (isMinimalSeparator(separator)) {
                        edgeSeparators.add(new Pair<>(
                            graph.getVertexIndex(v1),
                            graph.getVertexIndex(v2)
                        ));
                    }
                }
            }
            
            // Add the edge separators to global list
            if (!edgeSeparators.isEmpty()) {
                globalSeparators.add(new Pair<>(edgeSeparators, edge));
            }
        }
        
        return globalSeparators;
    }
    
    // Helper method to check if a set of vertices is a minimal separator
    private boolean isMinimalSeparator(Set<V> separator) {
        // Remove separator vertices from graph
        Set<V> remainingVertices = new HashSet<>(graph.vertexSet());
        remainingVertices.removeAll(separator);
        
        // Get connected components
        List<Set<V>> components = getConnectedComponents(remainingVertices);
        
        // Check if removing any vertex from separator would still separate components
        if (components.size() >= 2) {
            for (V v : separator) {
                Set<V> smallerSeparator = new HashSet<>(separator);
                smallerSeparator.remove(v);
                
                Set<V> remaining = new HashSet<>(graph.vertexSet());
                remaining.removeAll(smallerSeparator);
                
                List<Set<V>> newComponents = getConnectedComponents(remaining);
                
                // If components are still separated, this is not minimal
                if (newComponents.size() >= 2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    // Helper method to get connected components
    private List<Set<V>> getConnectedComponents(Set<V> vertices) {
        List<Set<V>> components = new ArrayList<>();
        Set<V> unvisited = new HashSet<>(vertices);
        
        while (!unvisited.isEmpty()) {
            V start = unvisited.iterator().next();
            Set<V> component = new HashSet<>();
            
            // DFS to find component
            Stack<V> stack = new Stack<>();
            stack.push(start);
            
            while (!stack.isEmpty()) {
                V current = stack.pop();
                if (unvisited.contains(current)) {
                    component.add(current);
                    unvisited.remove(current);
                    
                    for (V neighbor : graph.neighborListOf(current)) {
                        if (unvisited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
            
            components.add(component);
        }
        
        return components;
    }
}