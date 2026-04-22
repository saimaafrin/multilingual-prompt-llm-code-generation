import java.util.*;

public class MinimalSeparatorFinder {

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
            
            // Find minimal separators in the neighborhood of the edge
            List<Pair<Integer,Integer>> edgeSeparators = new ArrayList<>();
            
            // For each pair of common neighbors
            List<V> neighborList = new ArrayList<>(commonNeighbors);
            for (int i = 0; i < neighborList.size(); i++) {
                for (int j = i + 1; j < neighborList.size(); j++) {
                    V v1 = neighborList.get(i);
                    V v2 = neighborList.get(j);
                    
                    // Check if {v1,v2} forms a minimal separator
                    if (isMinimalSeparator(v1, v2)) {
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
    private boolean isMinimalSeparator(V v1, V v2) {
        // Remove v1 and v2 from graph temporarily
        Set<V> separator = new HashSet<>();
        separator.add(v1);
        separator.add(v2);
        
        // Check if removing these vertices increases number of connected components
        int originalComponents = countConnectedComponents(graph);
        int newComponents = countConnectedComponents(removeVertices(graph, separator));
        
        return newComponents > originalComponents;
    }
    
    // Helper method to count connected components in a graph
    private int countConnectedComponents(Graph<V,E> g) {
        Set<V> visited = new HashSet<>();
        int count = 0;
        
        for (V vertex : g.vertexSet()) {
            if (!visited.contains(vertex)) {
                dfs(g, vertex, visited);
                count++;
            }
        }
        
        return count;
    }
    
    // Helper method for DFS traversal
    private void dfs(Graph<V,E> g, V vertex, Set<V> visited) {
        visited.add(vertex);
        for (V neighbor : g.neighborListOf(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(g, neighbor, visited);
            }
        }
    }
    
    // Helper method to create a new graph with vertices removed
    private Graph<V,E> removeVertices(Graph<V,E> g, Set<V> verticesToRemove) {
        Graph<V,E> newGraph = g.clone();
        for (V vertex : verticesToRemove) {
            newGraph.removeVertex(vertex);
        }
        return newGraph;
    }
}