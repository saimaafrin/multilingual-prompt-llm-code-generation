import org.jgrapht.Graph;
import java.util.Set;

public class GraphUtils {
    /**
     * Verifica si el subgrafo de <code>graph</code> inducido por los <code>vertices</code> dados es completo, es decir, un clique.
     * @param graph el grafo.
     * @param vertices los vértices de los que se inducirá el subgrafo.
     * @return true si el subgrafo inducido es un clique.
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        // Para cada par de vértices distintos en el conjunto
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                // Si son el mismo vértice, continuamos
                if (v1.equals(v2)) {
                    continue;
                }
                
                // Si no existe una arista entre ellos, no es un clique
                if (!graph.containsEdge(v1, v2)) {
                    return false;
                }
            }
        }
        
        // Si llegamos aquí, todos los vértices están conectados entre sí
        return true;
    }
}