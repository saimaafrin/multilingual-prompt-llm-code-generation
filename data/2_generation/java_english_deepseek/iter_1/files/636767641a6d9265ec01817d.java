import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Map;

/**
 * Construct a complete bipartite graph
 */
@Override
public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
    // Assuming V is the vertex type and E is the edge type
    // Assuming the graph is undirected and simple (no loops or multiple edges)

    // Clear the target graph to ensure it's empty before generating
    target = new SimpleGraph<>(DefaultEdge.class);

    // Assuming resultMap contains two sets of vertices, one for each partition
    // For example, resultMap could have keys like "partition1_vertex1", "partition2_vertex1", etc.

    // Extract vertices from resultMap
    java.util.List<V> partition1 = new java.util.ArrayList<>();
    java.util.List<V> partition2 = new java.util.ArrayList<>();

    for (Map.Entry<String, V> entry : resultMap.entrySet()) {
        if (entry.getKey().startsWith("partition1_")) {
            partition1.add(entry.getValue());
        } else if (entry.getKey().startsWith("partition2_")) {
            partition2.add(entry.getValue());
        }
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