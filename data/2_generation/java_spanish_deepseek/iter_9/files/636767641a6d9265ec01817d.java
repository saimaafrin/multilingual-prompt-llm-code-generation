import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     * @param target El grafo en el que se generará el grafo bipartito
     * @param resultMap Un mapa para almacenar los vértices generados
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Crear dos conjuntos de vértices para las dos particiones
        Set<V> partitionA = new HashSet<>();
        Set<V> partitionB = new HashSet<>();

        // Generar vértices para la partición A
        for (int i = 0; i < 5; i++) {
            V vertexA = target.addVertex();
            partitionA.add(vertexA);
            resultMap.put("A" + i, vertexA);
        }

        // Generar vértices para la partición B
        for (int i = 0; i < 5; i++) {
            V vertexB = target.addVertex();
            partitionB.add(vertexB);
            resultMap.put("B" + i, vertexB);
        }

        // Conectar todos los vértices de la partición A con todos los de la partición B
        for (V vertexA : partitionA) {
            for (V vertexB : partitionB) {
                target.addEdge(vertexA, vertexB);
            }
        }
    }
}