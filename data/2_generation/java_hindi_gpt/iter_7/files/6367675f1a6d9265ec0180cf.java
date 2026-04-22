import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.GraphType;
import org.jgrapht.alg.clique.CliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class CliqueChecker {

    /** 
     * जांचें कि <code>graph</code> द्वारा दिए गए <code>vertices</code> से प्रेरित उपग्राफ पूर्ण है, अर्थात् एक क्लिक है।
     * @param graph ग्राफ।
     * @param vertices उपग्राफ को प्रेरित करने के लिए वर्टिस।
     * @return यदि प्रेरित उपग्राफ एक क्लिक है तो true।
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
        System.out.println("Is the induced subgraph a clique? " + result);
    }
}