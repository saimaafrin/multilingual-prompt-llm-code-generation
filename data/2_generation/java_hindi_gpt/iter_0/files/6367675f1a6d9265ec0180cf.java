import java.util.Set;
import org.jgrapht.Graph;

public class GraphUtils {

    /** 
     * जांचें कि <code>graph</code> द्वारा दिए गए <code>vertices</code> से प्रेरित उपग्राफ पूर्ण है, अर्थात् एक क्लिक है।
     * @param graph ग्राफ।
     * @param vertices उपग्राफ को प्रेरित करने के लिए वर्टिस।
     * @return यदि प्रेरित उपग्राफ एक क्लिक है तो true।
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        // Check if the number of edges in the induced subgraph equals the number of edges in a complete graph
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
}