import java.util.*;

public class MinimalSeparatorFinder {

    private Graph<V,E> graph; // Assume Graph class with vertices V and edges E exists
    
    /**
     * Computes the global separator list of the {@code graph}. More precisely, for every edge $e$ in the $G = (V, E)$ 
     * computes list of minimal separators $S_e$ in the neighborhood of $e$ and then concatenates these lists.
     * Note: the result may contain duplicates
     * @return the list of minimal separators of every edge $e$ in the inspected graph
     */
    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // Iterate through all edges in graph
        for (E edge : graph.edgeSet()) {
            // Get vertices incident to edge
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // Get neighborhood of both vertices
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborsOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborsOf(target));
            
            // Remove target from source neighbors and vice versa
            sourceNeighbors.remove(target);
            targetNeighbors.remove(source);
            
            // Find minimal separators in neighborhood
            List<Pair<Integer,Integer>> edgeSeparators = new ArrayList<>();
            
            // For each pair of vertices in neighborhood
            for (V v1 : sourceNeighbors) {
                for (V v2 : targetNeighbors) {
                    if (!graph.containsEdge(v1, v2)) {
                        // If vertices aren't connected, they form a minimal separator
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