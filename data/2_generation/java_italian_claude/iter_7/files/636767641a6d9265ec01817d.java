import java.util.*;
import org.jgrapht.*;

public class BipartiteGraphGenerator<V,E> implements GraphGenerator<V,E,V> {
    
    private int n1; // size of first partition
    private int n2; // size of second partition
    
    public BipartiteGraphGenerator(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void generateGraph(Graph<V,E> target, Map<String,V> resultMap) {
        // Create vertices for first partition
        List<V> partition1 = new ArrayList<>();
        for(int i = 0; i < n1; i++) {
            V vertex = target.vertexSupplier().get();
            target.addVertex(vertex);
            partition1.add(vertex);
            if(resultMap != null) {
                resultMap.put("P1_" + i, vertex);
            }
        }

        // Create vertices for second partition  
        List<V> partition2 = new ArrayList<>();
        for(int i = 0; i < n2; i++) {
            V vertex = target.vertexSupplier().get();
            target.addVertex(vertex);
            partition2.add(vertex);
            if(resultMap != null) {
                resultMap.put("P2_" + i, vertex);
            }
        }

        // Add edges between all vertices of different partitions
        for(V v1 : partition1) {
            for(V v2 : partition2) {
                target.addEdge(v1, v2);
            }
        }
    }
}