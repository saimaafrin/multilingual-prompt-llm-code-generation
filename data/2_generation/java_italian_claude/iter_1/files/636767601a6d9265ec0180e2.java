import java.util.*;
import javafx.util.Pair;
import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;

public class SeparatorCalculator<V,E> {
    private Graph<V,E> graph;
    
    public SeparatorCalculator(Graph<V,E> g) {
        this.graph = g;
    }

    /**
     * Calcola la lista globale dei separatori del {@code grafo}. Più precisamente, per ogni arco $e$ in $G = (V, E)$ 
     * calcola la lista dei separatori minimi $S_e$ nel vicinato di $e$ e poi concatena queste liste. 
     * Nota: il risultato può contenere duplicati.
     * @return la lista dei separatori minimi di ogni arco $e$ nel grafo ispezionato
     */
    private List<Pair<List<Pair<Integer,Integer>>,E>> computeGlobalSeparatorList() {
        List<Pair<List<Pair<Integer,Integer>>,E>> globalSeparators = new ArrayList<>();
        
        // Iterate through all edges in the graph
        for (E edge : graph.edgeSet()) {
            V source = graph.getEdgeSource(edge);
            V target = graph.getEdgeTarget(edge);
            
            // Get neighbors of both vertices of the edge
            Set<V> sourceNeighbors = new HashSet<>(graph.neighborSetOf(source));
            Set<V> targetNeighbors = new HashSet<>(graph.neighborSetOf(target));
            
            // Find common neighbors (potential separators)
            sourceNeighbors.retainAll(targetNeighbors);
            
            // Create list of minimal separators for this edge
            List<Pair<Integer,Integer>> edgeSeparators = new ArrayList<>();
            
            // For each common neighbor pair, check if they form a separator
            List<V> commonNeighbors = new ArrayList<>(sourceNeighbors);
            for (int i = 0; i < commonNeighbors.size(); i++) {
                for (int j = i + 1; j < commonNeighbors.size(); j++) {
                    V v1 = commonNeighbors.get(i);
                    V v2 = commonNeighbors.get(j);
                    
                    // Create temporary graph without these vertices
                    Graph<V,E> tempGraph = (Graph<V,E>) graph.clone();
                    tempGraph.removeVertex(v1);
                    tempGraph.removeVertex(v2);
                    
                    // Check if removing these vertices disconnects source and target
                    ConnectivityInspector<V,E> inspector = new ConnectivityInspector<>(tempGraph);
                    if (!inspector.pathExists(source, target)) {
                        // Found a minimal separator
                        int index1 = commonNeighbors.indexOf(v1);
                        int index2 = commonNeighbors.indexOf(v2);
                        edgeSeparators.add(new Pair<>(index1, index2));
                    }
                }
            }
            
            // Add the edge and its separators to global list
            globalSeparators.add(new Pair<>(edgeSeparators, edge));
        }
        
        return globalSeparators;
    }
}