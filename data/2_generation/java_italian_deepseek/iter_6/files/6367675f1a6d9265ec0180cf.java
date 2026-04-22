import org.jgrapht.Graph;
import java.util.Set;

public class CliqueChecker {

    /**
     * Controlla se il sottografo di <code>graph</code> indotto dai dati <code>vertices</code> è completo, cioè un clique.
     * @param graph il grafo.
     * @param vertices i vertici da cui indurre il sottografo.
     * @return true se il sottografo indotto è un clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Verifica che ogni coppia di vertici sia connessa da un arco
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false;
                }
            }
        }
        return true;
    }
}