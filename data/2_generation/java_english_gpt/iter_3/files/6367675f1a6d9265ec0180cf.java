import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.alg.clique.CliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.HashSet;
import java.util.Set;

public class GraphUtils {

    /** 
     * Check whether the subgraph of <code>graph</code> induced by the given <code>vertices</code> is complete, i.e. a clique.
     * @param graph the graph.
     * @param vertices the vertices to induce the subgraph from.
     * @return true if the induced subgraph is a clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Check if the vertices set is empty or has only one vertex
        if (vertices.isEmpty() || vertices.size() == 1) {
            return true;
        }

        // Check if every pair of vertices in the set is connected
        for (V v1 : vertices) {
            for (V v2 : vertices) {
                if (!v1.equals(v2) && !graph.containsEdge(v1, v2)) {
                    return false; // Found a pair that is not connected
                }
            }
        }
        return true; // All pairs are connected
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

        Set<String> vertices = new HashSet<>();
        vertices.add("A");
        vertices.add("B");
        vertices.add("C");

        System.out.println(isClique(graph, vertices)); // Should print true
    }
}