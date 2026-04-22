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
    // Assumiamo che V sia il tipo di vertice e E sia il tipo di arco
    // Creiamo due partizioni di vertici
    List<V> partition1 = new ArrayList<>();
    List<V> partition2 = new ArrayList<>();

    // Aggiungiamo i vertici alle partizioni
    for (Map.Entry<String, V> entry : resultMap.entrySet()) {
        String key = entry.getKey();
        V vertex = entry.getValue();
        if (key.startsWith("A")) {
            partition1.add(vertex);
        } else if (key.startsWith("B")) {
            partition2.add(vertex);
        }
    }

    // Aggiungiamo i vertici al grafo
    for (V vertex : partition1) {
        target.addVertex(vertex);
    }
    for (V vertex : partition2) {
        target.addVertex(vertex);
    }

    // Creiamo gli archi tra tutte le coppie di vertici delle due partizioni
    for (V v1 : partition1) {
        for (V v2 : partition2) {
            target.addEdge(v1, v2);
        }
    }
}