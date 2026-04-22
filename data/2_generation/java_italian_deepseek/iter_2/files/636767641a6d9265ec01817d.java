import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Costruisce un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Assumiamo che resultMap contenga due chiavi: "left" e "right" che rappresentano i due insiemi di vertici
        List<V> leftVertices = (List<V>) resultMap.get("left");
        List<V> rightVertices = (List<V>) resultMap.get("right");

        if (leftVertices == null || rightVertices == null) {
            throw new IllegalArgumentException("resultMap deve contenere le chiavi 'left' e 'right'");
        }

        // Aggiungi tutti i vertici al grafo
        for (V vertex : leftVertices) {
            target.addVertex(vertex);
        }
        for (V vertex : rightVertices) {
            target.addVertex(vertex);
        }

        // Aggiungi tutti gli archi tra i vertici di sinistra e quelli di destra
        for (V leftVertex : leftVertices) {
            for (V rightVertex : rightVertices) {
                target.addEdge(leftVertex, rightVertex);
            }
        }
    }
}