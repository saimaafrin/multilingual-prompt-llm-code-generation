import java.util.*;
import javafx.util.Pair;

public class SeparatorComputer {
    private Graph<V,E> graph; // Assuming a graph class with vertices V and edges E
    
    /**
     * Calcola la lista globale dei separatori del {@code grafo}. Più precisamente, per ogni arco $e$ in $G = (V, E)$ calcola la lista dei separatori minimi $S_e$ nel vicinato di $e$ e poi concatena queste liste. Nota: il risultato può contenere duplicati.
     * @return la lista dei separatori minimi di ogni arco $e$ nel grafo ispezionato
     */
    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // Iterate through all edges in the graph
        for (E edge : graph.edges()) {
            List<Pair<Integer,Integer>> separators = new ArrayList<>();
            
            // Get vertices incident to the edge
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // Get neighborhood of both vertices
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborsOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborsOf(target));
            
            // Find common neighbors that form minimal separators
            Set<V> commonNeighbors = new HashSet<>(sourceNeighbors);
            commonNeighbors.retainAll(targetNeighbors);
            
            // For each pair of common neighbors, check if they form a minimal separator
            for (V v1 : commonNeighbors) {
                for (V v2 : commonNeighbors) {
                    if (!v1.equals(v2)) {
                        // Assuming vertices have integer IDs
                        int id1 = v1.getId();
                        int id2 = v2.getId();
                        
                        // Check if {v1,v2} is a minimal separator
                        if (isMinimalSeparator(v1, v2, source, target)) {
                            separators.add(new Pair<>(id1, id2));
                        }
                    }
                }
            }
            
            // Add the edge and its separators to global list
            globalSeparators.add(new Pair<>(separators, edge));
        }
        
        return globalSeparators;
    }
    
    // Helper method to check if two vertices form a minimal separator
    private boolean isMinimalSeparator(V v1, V v2, V source, V target) {
        // Remove v1 and v2 from graph temporarily
        Set<V> removed = new HashSet<>();
        removed.add(v1);
        removed.add(v2);
        
        // Check if source and target are disconnected when v1,v2 are removed
        return !hasPath(source, target, removed);
    }
    
    // Helper method to check if there exists a path between two vertices
    private boolean hasPath(V start, V end, Set<V> excluded) {
        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            V current = queue.poll();
            if (current.equals(end)) {
                return true;
            }
            
            for (V neighbor : graph.neighborsOf(current)) {
                if (!visited.contains(neighbor) && !excluded.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
}