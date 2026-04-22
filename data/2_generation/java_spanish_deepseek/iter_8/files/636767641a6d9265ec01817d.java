import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Construir un grafo bipartito completo
 */
@Override
public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
    // Asumimos que resultMap contiene dos claves: "left" y "right" que representan los dos conjuntos de vértices
    Set<V> leftSet = new HashSet<>(resultMap.get("left"));
    Set<V> rightSet = new HashSet<>(resultMap.get("right"));

    // Añadir todos los vértices al grafo
    for (V vertex : leftSet) {
        target.addVertex(vertex);
    }
    for (V vertex : rightSet) {
        target.addVertex(vertex);
    }

    // Conectar cada vértice del conjunto izquierdo con cada vértice del conjunto derecho
    for (V leftVertex : leftSet) {
        for (V rightVertex : rightSet) {
            target.addEdge(leftVertex, rightVertex);
        }
    }
}