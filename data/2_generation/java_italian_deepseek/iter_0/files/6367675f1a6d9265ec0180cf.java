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
        for (V u : vertices) {
            for (V v : vertices) {
                if (!u.equals(v) && !graph.containsEdge(u, v)) {
                    return false;
                }
            }
        }
        return true;
    }
}