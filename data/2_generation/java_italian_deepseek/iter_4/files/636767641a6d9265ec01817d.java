import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Costruisce un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Assuming V is the vertex type and E is the edge type
        // Assuming the graph is undirected and uses DefaultEdge for edges

        // Clear the target graph and resultMap to start fresh
        target.vertexSet().clear();
        resultMap.clear();

        // Create two partitions of vertices
        List<V> partition1 = new ArrayList<>();
        List<V> partition2 = new ArrayList<>();

        // Add vertices to the partitions
        for (int i = 0; i < 5; i++) { // Example: 5 vertices in each partition
            V vertex1 = target.addVertex();
            V vertex2 = target.addVertex();
            partition1.add(vertex1);
            partition2.add(vertex2);
            resultMap.put("Partition1_Vertex" + i, vertex1);
            resultMap.put("Partition2_Vertex" + i, vertex2);
        }

        // Connect every vertex in partition1 to every vertex in partition2
        for (V v1 : partition1) {
            for (V v2 : partition2) {
                target.addEdge(v1, v2);
            }
        }
    }
}