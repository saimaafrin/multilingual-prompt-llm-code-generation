import java.util.*;

public class BipartiteGraphGenerator<V,E> {

    /**
     * 构建一个完整的二分图
     */
    @Override
    public void generateGraph(Graph<V,E> target, Map<String,V> resultMap) {
        if (target == null || resultMap == null) {
            throw new IllegalArgumentException("Target graph and result map cannot be null");
        }

        // Get vertices from each partition
        List<V> leftPartition = new ArrayList<>();
        List<V> rightPartition = new ArrayList<>();
        
        for (Map.Entry<String,V> entry : resultMap.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("L")) {
                leftPartition.add(entry.getValue());
            } else if (key.startsWith("R")) {
                rightPartition.add(entry.getValue());
            }
        }

        // Add all vertices to graph
        for (V vertex : leftPartition) {
            target.addVertex(vertex);
        }
        for (V vertex : rightPartition) {
            target.addVertex(vertex);
        }

        // Connect each vertex in left partition to all vertices in right partition
        for (V leftVertex : leftPartition) {
            for (V rightVertex : rightPartition) {
                target.addEdge(leftVertex, rightVertex);
            }
        }
    }
}