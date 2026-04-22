import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Map;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Costruisce un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Assumiamo che il grafo sia bipartito con due partizioni A e B
        // Creiamo i vertici per le due partizioni
        V[] partitionA = (V[]) new Object[resultMap.size() / 2];
        V[] partitionB = (V[]) new Object[resultMap.size() / 2];

        int indexA = 0;
        int indexB = 0;

        // Dividiamo i vertici in due partizioni
        for (Map.Entry<String, V> entry : resultMap.entrySet()) {
            if (indexA < partitionA.length) {
                partitionA[indexA++] = entry.getValue();
            } else {
                partitionB[indexB++] = entry.getValue();
            }
        }

        // Aggiungiamo tutti i vertici al grafo
        for (V vertex : partitionA) {
            target.addVertex(vertex);
        }
        for (V vertex : partitionB) {
            target.addVertex(vertex);
        }

        // Creiamo un arco tra ogni vertice di A e ogni vertice di B
        for (V vertexA : partitionA) {
            for (V vertexB : partitionB) {
                target.addEdge(vertexA, vertexB);
            }
        }
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        Map<String, String> resultMap = Map.of(
                "v1", "A1",
                "v2", "A2",
                "v3", "B1",
                "v4", "B2"
        );

        BipartiteGraphGenerator<String, DefaultEdge> generator = new BipartiteGraphGenerator<>();
        generator.generateGraph(graph, resultMap);

        System.out.println("Grafo bipartito generato:");
        System.out.println("Vertici: " + graph.vertexSet());
        System.out.println("Archi: " + graph.edgeSet());
    }
}