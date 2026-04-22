import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Costruisce un grafo bipartito completo
 */
@Override
public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
    // Creare due partizioni di vertici
    List<V> partition1 = new ArrayList<>();
    List<V> partition2 = new ArrayList<>();

    // Aggiungere vertici alla prima partizione
    for (int i = 0; i < 5; i++) {
        V vertex = target.addVertex();
        partition1.add(vertex);
        resultMap.put("partition1_vertex" + i, vertex);
    }

    // Aggiungere vertici alla seconda partizione
    for (int i = 0; i < 5; i++) {
        V vertex = target.addVertex();
        partition2.add(vertex);
        resultMap.put("partition2_vertex" + i, vertex);
    }

    // Creare archi tra tutte le coppie di vertici delle due partizioni
    for (V v1 : partition1) {
        for (V v2 : partition2) {
            target.addEdge(v1, v2);
        }
    }
}