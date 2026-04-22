import java.util.*;

public class GraphUtils {
    /**
     * Check whether the subgraph of <code>graph</code> induced by the given <code>vertices</code> is complete, i.e. a clique.
     * @param graph the graph.
     * @param vertices the vertices to induce the subgraph from.
     * @return true if the induced subgraph is a clique.
     */
    public static boolean isClique(Graph graph, Set<Integer> vertices) {
        // For a complete subgraph, each vertex must be connected to all other vertices
        for (Integer v1 : vertices) {
            for (Integer v2 : vertices) {
                // Skip self loops
                if (v1.equals(v2)) {
                    continue;
                }
                // If any two vertices are not connected, it's not a clique
                if (!graph.hasEdge(v1, v2)) {
                    return false;
                }
            }
        }
        return true;
    }
}

// Assuming a Graph interface/class that has a hasEdge method
interface Graph {
    boolean hasEdge(Integer source, Integer target);
}