import java.util.Set;
import java.util.HashSet;

public class GraphUtils {

    /**
     * 检查由给定的 <code>vertices</code> 诱导的 <code>graph</code> 的子图是否为完全图，即一个团。
     * @param graph 图。
     * @param vertices 用于诱导子图的顶点。
     * @return 如果诱导的子图是一个团，则返回真。
     */
    private static <V, E> boolean isClique(Graph<V, E> graph, Set<V> vertices) {
        if (vertices.size() < 2) {
            return true; // A single vertex or empty set is trivially a clique
        }

        int expectedEdges = vertices.size() * (vertices.size() - 1) / 2; // n(n-1)/2
        int actualEdges = 0;

        for (V vertex : vertices) {
            Set<V> neighbors = graph.getNeighbors(vertex);
            for (V neighbor : neighbors) {
                if (vertices.contains(neighbor)) {
                    actualEdges++;
                }
            }
        }

        // Each edge is counted twice (u-v and v-u), so divide by 2
        actualEdges /= 2;

        return actualEdges == expectedEdges;
    }
}

// Assuming a Graph interface exists with the following method
interface Graph<V, E> {
    Set<V> getNeighbors(V vertex);
}