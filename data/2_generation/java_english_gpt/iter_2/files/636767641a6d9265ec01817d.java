import java.util.Map;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construct a complete bipartite graph
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        if (resultMap == null || resultMap.size() < 2) {
            throw new IllegalArgumentException("resultMap must contain at least two vertices.");
        }

        // Split the resultMap into two sets
        V[] vertices = (V[]) resultMap.values().toArray();
        int mid = vertices.length / 2;

        // Add vertices to the target graph
        for (int i = 0; i < mid; i++) {
            target.addVertex(vertices[i]);
        }
        for (int i = mid; i < vertices.length; i++) {
            target.addVertex(vertices[i]);
        }

        // Create edges between the two sets of vertices
        for (int i = 0; i < mid; i++) {
            for (int j = mid; j < vertices.length; j++) {
                target.addEdge(vertices[i], vertices[j]);
            }
        }
    }
}

// Assuming a simple Graph interface
interface Graph<V, E> {
    void addVertex(V vertex);
    void addEdge(V vertex1, V vertex2);
}