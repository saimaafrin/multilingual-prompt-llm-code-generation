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
                // Se sono vertici diversi
                if (!v1.equals(v2)) {
                    // Se non esiste un arco tra loro, non è un clique
                    if (!graph.containsEdge(v1, v2)) {
                        return false;
                    }
                }
            }
        }
        // Se arriviamo qui, ogni coppia di vertici è collegata
        return true;
    }
}