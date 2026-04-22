import org.jgrapht.Graph;
import java.util.Set;

public class GraphUtils {
    /**
     * Controlla se il sottografo di <code>graph</code> indotto dai dati <code>vertices</code> è completo, cioè un clique.
     * @param graph il grafo.
     * @param vertices i vertici da cui indurre il sottografo.
     * @return true se il sottografo indotto è un clique.
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        // Per ogni coppia di vertici nel set
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                // Salta il confronto di un vertice con se stesso
                if (v1.equals(v2)) {
                    continue;
                }
                // Se non esiste un arco tra i due vertici, non è un clique
                if (!graph.containsEdge(v1, v2)) {
                    return false;
                }
            }
        }
        // Se arriviamo qui, tutti i vertici sono collegati tra loro
        return true;
    }
}