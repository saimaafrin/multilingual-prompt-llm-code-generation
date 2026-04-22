import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     * 
     * @param target El grafo en el que se construirá el grafo bipartito completo.
     * @param resultMap Un mapa para almacenar los vértices generados.
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Crear dos conjuntos de vértices para el grafo bipartito
        List<V> setA = new ArrayList<>();
        List<V> setB = new ArrayList<>();

        // Generar vértices para el conjunto A
        for (int i = 0; i < 5; i++) {
            V vertex = target.addVertex();
            setA.add(vertex);
            resultMap.put("A" + i, vertex);
        }

        // Generar vértices para el conjunto B
        for (int i = 0; i < 5; i++) {
            V vertex = target.addVertex();
            setB.add(vertex);
            resultMap.put("B" + i, vertex);
        }

        // Conectar todos los vértices de A con todos los vértices de B
        for (V a : setA) {
            for (V b : setB) {
                target.addEdge(a, b);
            }
        }
    }
}