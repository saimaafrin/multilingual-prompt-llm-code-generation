import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.alg.clique.CliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Set;

public class GraphUtils {

    /** 
     * Verifica si el subgrafo de <code>graph</code> inducido por los <code>vertices</code> dados es completo, es decir, un clique.
     * @param graph el grafo.
     * @param vertices los vértices de los que se inducirá el subgrafo.
     * @return true si el subgrafo inducido es un clique.
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        // Check if the number of edges in the induced subgraph is equal to the number of edges in a complete graph
        int vertexCount = vertices.size();
        int expectedEdges = vertexCount * (vertexCount - 1) / 2; // Complete graph edges formula

        int actualEdges = 0;
        for (V vertex : vertices) {
            for (E edge : graph.outgoingEdgesOf(vertex)) {
                V targetVertex = graph.getEdgeTarget(edge);
                if (vertices.contains(targetVertex)) {
                    actualEdges++;
                }
            }
        }

        // Each edge is counted twice (once from each vertex), so divide by 2
        actualEdges /= 2;

        return actualEdges == expectedEdges;
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
        boolean result = isClique(graph, vertices);
        System.out.println("Is clique: " + result); // Should print true
    }
}