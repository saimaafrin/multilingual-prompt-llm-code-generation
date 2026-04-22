import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.alg.clique.CliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Set;

public class CliqueChecker {

    /** 
     * Verifica si el subgrafo de <code>graph</code> inducido por los <code>vertices</code> dados es completo, es decir, un clique.
     * @param graph el grafo.
     * @param vertices los vértices de los que se inducirá el subgrafo.
     * @return true si el subgrafo inducido es un clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Check if the number of vertices is less than 2
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        // Check all pairs of vertices in the set
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // If any pair is not connected, it's not a clique
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
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        Set<String> vertices = Set.of("A", "B", "C");
        System.out.println(isClique(graph, vertices)); // Should print true
    }
}