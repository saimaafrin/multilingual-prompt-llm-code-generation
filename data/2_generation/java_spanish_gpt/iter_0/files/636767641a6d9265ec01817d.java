import java.util.Map;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        if (resultMap == null || resultMap.size() < 2) {
            throw new IllegalArgumentException("resultMap must contain at least two vertices.");
        }

        // Get the keys from the resultMap
        String[] keys = resultMap.keySet().toArray(new String[0]);
        int mid = keys.length / 2;

        // Add edges between the two partitions
        for (int i = 0; i < mid; i++) {
            for (int j = mid; j < keys.length; j++) {
                V vertex1 = resultMap.get(keys[i]);
                V vertex2 = resultMap.get(keys[j]);
                target.addEdge(vertex1, vertex2);
            }
        }
    }
}

// Assuming a simple Graph interface
interface Graph<V, E> {
    void addEdge(V vertex1, V vertex2);
}