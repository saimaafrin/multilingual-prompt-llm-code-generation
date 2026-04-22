import java.util.*;
import org.jgrapht.*;

public class BipartiteGraphGenerator<V,E> implements GraphGenerator<V,E,V> {
    private int n1; // number of vertices in first partition
    private int n2; // number of vertices in second partition
    
    public BipartiteGraphGenerator(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void generateGraph(Graph<V,E> target, Map<String,V> resultMap) {
        // Create vertices for first partition
        List<V> partition1 = new ArrayList<>();
        for(int i = 0; i < n1; i++) {
            V vertex = resultMap.get("v1" + i);
            target.addVertex(vertex);
            partition1.add(vertex);
        }

        // Create vertices for second partition  
        List<V> partition2 = new ArrayList<>();
        for(int i = 0; i < n2; i++) {
            V vertex = resultMap.get("v2" + i);
            target.addVertex(vertex);
            partition2.add(vertex);
        }

        // Add edges between all vertices in partition1 and partition2
        for(V v1 : partition1) {
            for(V v2 : partition2) {
                target.addEdge(v1, v2);
            }
        }
    }
}