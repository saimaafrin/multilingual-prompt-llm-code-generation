import java.util.*;
import org.jgrapht.*;

public class BipartiteGraphGenerator<V,E> implements GraphGenerator<V,E,V> {

    @Override
    public void generateGraph(Graph<V,E> target, Map<String,V> resultMap) {
        if (target == null) {
            throw new IllegalArgumentException("Target graph cannot be null");
        }

        // Create two sets of vertices for bipartite graph
        List<V> partition1 = new ArrayList<>();
        List<V> partition2 = new ArrayList<>();

        // Add vertices from resultMap to partitions
        if (resultMap != null) {
            for (Map.Entry<String,V> entry : resultMap.entrySet()) {
                if (entry.getKey().startsWith("A")) {
                    partition1.add(entry.getValue());
                } else if (entry.getKey().startsWith("B")) {
                    partition2.add(entry.getValue());
                }
                target.addVertex(entry.getValue());
            }
        }

        // Connect every vertex in partition1 to every vertex in partition2
        for (V v1 : partition1) {
            for (V v2 : partition2) {
                target.addEdge(v1, v2);
            }
        }
    }
}