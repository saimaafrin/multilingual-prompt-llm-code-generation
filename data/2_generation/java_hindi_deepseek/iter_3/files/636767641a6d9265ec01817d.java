import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * एक पूर्ण द्विभाजित ग्राफ का निर्माण करें
 */
@Override
public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
    // Assuming V is the vertex type and E is the edge type
    // Create two partitions of vertices
    V[] partition1 = (V[]) new Object[resultMap.size() / 2];
    V[] partition2 = (V[]) new Object[resultMap.size() / 2];

    int i = 0;
    for (Map.Entry<String, V> entry : resultMap.entrySet()) {
        if (i < partition1.length) {
            partition1[i] = entry.getValue();
        } else {
            partition2[i - partition1.length] = entry.getValue();
        }
        i++;
    }

    // Add all vertices to the graph
    for (V vertex : partition1) {
        target.addVertex(vertex);
    }
    for (V vertex : partition2) {
        target.addVertex(vertex);
    }

    // Add edges between all vertices in partition1 and partition2
    for (V v1 : partition1) {
        for (V v2 : partition2) {
            target.addEdge(v1, v2);
        }
    }
}