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
            
            // Get neighborhood of both endpoints
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborListOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborListOf(target));
            
            // Remove the endpoints themselves from neighbor sets
            sourceNeighbors.remove(target);
            targetNeighbors.remove(source);
            
            // Find minimal separators for this edge
            List<Pair<Integer,Integer>> edgeSeparators = new ArrayList<>();
            
            // For each pair of vertices in the neighborhoods
            for (V s : sourceNeighbors) {
                for (V t : targetNeighbors) {
                    // If vertices are not connected, they form a minimal separator
                    if (!graph.containsEdge(s, t)) {
                        edgeSeparators.add(new Pair<>(
                            graph.getVertexIndex(s),
                            graph.getVertexIndex(t)
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
    
    // Helper class for pairs
    private static class Pair<X,Y> {
        private final X first;
        private final Y second;
        
        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }
        
        public X getFirst() {
            return first;
        }
        
        public Y getSecond() {
            return second;
        }
    }
}