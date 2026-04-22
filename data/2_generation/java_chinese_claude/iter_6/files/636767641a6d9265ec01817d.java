import java.util.*;

public class BipartiteGraphGenerator<V,E> implements GraphGenerator<V,E> {

    @Override
    public void generateGraph(Graph<V,E> target, Map<String,V> resultMap) {
        if (target == null || resultMap == null) {
            throw new IllegalArgumentException("Graph and result map cannot be null");
        }

        // Clear the target graph
        target.clear();

        // Get vertices from result map
        List<V> leftSet = new ArrayList<>();
        List<V> rightSet = new ArrayList<>();
        
        // Split vertices into two sets
        for (Map.Entry<String,V> entry : resultMap.entrySet()) {
            if (entry.getKey().startsWith("L")) {
                leftSet.add(entry.getValue());
            } else if (entry.getKey().startsWith("R")) {
                rightSet.add(entry.getValue());
            }
        }

        // Add all vertices to graph
        for (V vertex : leftSet) {
            target.addVertex(vertex);
        }
        for (V vertex : rightSet) {
            target.addVertex(vertex);
        }

        // Connect each vertex in left set to all vertices in right set
        for (V leftVertex : leftSet) {
            for (V rightVertex : rightSet) {
                target.addEdge(leftVertex, rightVertex);
            }
        }
    }
}