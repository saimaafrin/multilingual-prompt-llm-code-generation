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
            
            // Create pairs of vertices that form minimal separators
            for (V v1 : commonNeighbors) {
                for (V v2 : commonNeighbors) {
                    if (!v1.equals(v2)) {
                        // Assuming vertices have integer IDs
                        int id1 = v1.getId();
                        int id2 = v2.getId();
                        // Add separator pair in sorted order to avoid duplicates
                        if (id1 < id2) {
                            separators.add(new Pair<>(id1, id2));
                        } else {
                            separators.add(new Pair<>(id2, id1));
                        }
                    }
                }
            }
            
            // Add the separators list along with the edge to global list
            globalSeparators.add(new Pair<>(separators, edge));
        }
        
        return globalSeparators;
    }
}