import java.util.*;

public class GraphUtils {
    /**
     * Check whether the subgraph of <code>graph</code> induced by the given <code>vertices</code> is complete, i.e. a clique.
     * @param graph the graph.
     * @param vertices the vertices to induce the subgraph from.
     * @return true if the induced subgraph is a clique.
     */
    public static boolean isClique(Graph graph, Set<Integer> vertices) {
        // For each pair of vertices in the set
        for (Integer v1 : vertices) {
            for (Integer v2 : vertices) {
                // Skip self loops
                if (v1.equals(v2)) {
                    continue;
                }
                
                // If any pair of vertices is not connected by an edge,
                // then this is not a clique
                if (!graph.hasEdge(v1, v2)) {
                    return false;
                }
            }
        }
        
        // If we get here, all vertices are connected to each other
        return true;
    }
}

// Sample Graph interface that would be needed
interface Graph {
    boolean hasEdge(Integer source, Integer target);
}