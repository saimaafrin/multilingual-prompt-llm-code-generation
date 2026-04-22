import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     * 
     * @param target El grafo en el que se construirá el grafo bipartito
     * @param resultMap Un mapa para almacenar los vértices generados
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Supongamos que los vértices de la partición izquierda son A, B, C, etc.
        // y los vértices de la partición derecha son 1, 2, 3, etc.
        
        // Crear vértices para la partición izquierda
        Set<V> leftPartition = new HashSet<>();
        leftPartition.add(target.addVertex());
        leftPartition.add(target.addVertex());
        leftPartition.add(target.addVertex());
        
        // Crear vértices para la partición derecha
        Set<V> rightPartition = new HashSet<>();
        rightPartition.add(target.addVertex());
        rightPartition.add(target.addVertex());
        rightPartition.add(target.addVertex());
        
        // Almacenar los vértices en el resultMap
        int i = 0;
        for (V vertex : leftPartition) {
            resultMap.put("L" + i, vertex);
            i++;
        }
        
        i = 0;
        for (V vertex : rightPartition) {
            resultMap.put("R" + i, vertex);
            i++;
        }
        
        // Conectar cada vértice de la partición izquierda con cada vértice de la partición derecha
        for (V leftVertex : leftPartition) {
            for (V rightVertex : rightPartition) {
                target.addEdge(leftVertex, rightVertex);
            }
        }
    }
}