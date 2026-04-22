import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Set;

public class CliqueChecker {

    /** 
     * Controlla se il sottografo di <code>graph</code> indotto dai dati <code>vertices</code> è completo, cioè un clique.
     * @param graph il grafo.
     * @param vertices i vertici da cui indurre il sottografo.
     * @return true se il sottografo indotto è un clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // If any pair of vertices is not connected, it's not a clique
                }
            }
        }
        return true; // All pairs are connected, it's a clique
    }

    public static void main(String[] args) {
        // Example usage
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");

        Set<String> vertices = Set.of("A", "B", "C");
        System.out.println(isClique(graph, vertices)); // Should print true
    }
}