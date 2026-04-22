import org.jgrapht.Graph;
import java.util.Set;

public class CliqueChecker {

    /**
     * Verifica si el subgrafo de <code>graph</code> inducido por los <code>vertices</code> dados es completo, es decir, un clique.
     * @param graph el grafo.
     * @param vertices los vértices de los que se inducirá el subgrafo.
     * @return true si el subgrafo inducido es un clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Verificar si todos los pares de vértices están conectados
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) { // No es necesario verificar la conexión de un vértice consigo mismo
                    if (!graph.containsEdge(v1, v2)) {
                        return false; // Si falta una arista, no es un clique
                    }
                }
            }
        }
        return true; // Si todos los pares están conectados, es un clique
    }
}