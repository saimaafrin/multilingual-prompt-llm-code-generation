import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;

public class GraphUtils {

    /** 
     * Verifica si el subgrafo de <code>graph</code> inducido por los <code>vertices</code> dados es completo, es decir, un clique.
     * @param graph el grafo.
     * @param vertices los vértices de los que se inducirá el subgrafo.
     * @return true si el subgrafo inducido es un clique.
     */
    private static <V,E> boolean isClique(Graph<V,E> graph, Set<V> vertices) {
        // Check if the number of edges in the induced subgraph equals the number of edges in a complete graph
        int expectedEdges = vertices.size() * (vertices.size() - 1) / 2;
        int actualEdges = 0;

        for (V vertex : vertices) {
            for (E edge : graph.outgoingEdgesOf(vertex)) {
                V targetVertex = Graphs.getOppositeVertex(graph, edge, vertex);
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