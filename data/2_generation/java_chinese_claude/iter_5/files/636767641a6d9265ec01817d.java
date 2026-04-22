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
            if (entry.getKey().startsWith("L")) {
                leftPartition.add(entry.getValue());
            } else if (entry.getKey().startsWith("R")) {
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

        // Add edges between all vertices in left and right partitions
        for (V left : leftPartition) {
            for (V right : rightPartition) {
                target.addEdge(left, right);
            }
        }
    }
}