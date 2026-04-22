import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Costruisce un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Assuming Graph<V, E> has methods to add vertices and edges
        // Assuming V is the vertex type and E is the edge type

        // Extract vertices from the resultMap
        List<V> vertices = new ArrayList<>(resultMap.values());

        // Split vertices into two partitions
        int mid = vertices.size() / 2;
        List<V> partitionA = vertices.subList(0, mid);
        List<V> partitionB = vertices.subList(mid, vertices.size());

        // Add all vertices to the graph
        for (V vertex : vertices) {
            target.addVertex(vertex);
        }

        // Add edges between all vertices in partitionA and partitionB
        for (V a : partitionA) {
            for (V b : partitionB) {
                target.addEdge(a, b);
            }
        }
    }
}

// Assuming the Graph interface looks something like this:
interface Graph<V, E> {
    void addVertex(V vertex);
    void addEdge(V source, V target);
}