import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Asumimos que resultMap contiene dos listas de vértices bajo las claves "left" y "right"
        List<V> leftVertices = (List<V>) resultMap.get("left");
        List<V> rightVertices = (List<V>) resultMap.get("right");

        if (leftVertices == null || rightVertices == null) {
            throw new IllegalArgumentException("resultMap debe contener las claves 'left' y 'right' con listas de vértices.");
        }

        // Añadir todos los vértices al grafo
        for (V vertex : leftVertices) {
            target.addVertex(vertex);
        }
        for (V vertex : rightVertices) {
            target.addVertex(vertex);
        }

        // Conectar cada vértice de la izquierda con cada vértice de la derecha
        for (V leftVertex : leftVertices) {
            for (V rightVertex : rightVertices) {
                target.addEdge(leftVertex, rightVertex);
            }
        }
    }
}

// Asumimos que la interfaz Graph tiene los siguientes métodos:
interface Graph<V, E> {
    void addVertex(V vertex);
    void addEdge(V source, V target);
}