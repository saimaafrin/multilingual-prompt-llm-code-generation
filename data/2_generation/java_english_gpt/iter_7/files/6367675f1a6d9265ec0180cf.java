import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.alg.clique.CliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Set;

public class GraphUtils {

    /** 
     * Check whether the subgraph of <code>graph</code> induced by the given <code>vertices</code> is complete, i.e. a clique.
     * @param graph the graph.
     * @param vertices the vertices to induce the subgraph from.
     * @return true if the induced subgraph is a clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // Found a pair of vertices that are not connected
                }
            }
        }
        return true; // All pairs of vertices are connected
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