import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     * 
     * @param target El grafo en el que se construirá el grafo bipartito completo.
     * @param resultMap Un mapa para almacenar los vértices generados, donde la clave es un identificador único.
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Supongamos que el grafo bipartito tiene dos conjuntos de vértices: U y V
        Set<V> setU = new HashSet<>();
        Set<V> setV = new HashSet<>();

        // Generar vértices para el conjunto U
        for (int i = 0; i < 5; i++) { // Ejemplo: 5 vértices en U
            V vertexU = target.addVertex();
            setU.add(vertexU);
            resultMap.put("U" + i, vertexU);
        }

        // Generar vértices para el conjunto V
        for (int i = 0; i < 5; i++) { // Ejemplo: 5 vértices en V
            V vertexV = target.addVertex();
            setV.add(vertexV);
            resultMap.put("V" + i, vertexV);
        }

        // Conectar cada vértice en U con cada vértice en V
        for (V u : setU) {
            for (V v : setV) {
                target.addEdge(u, v);
            }
        }
    }
}

// Interface Graph asumida para el ejemplo
interface Graph<V, E> {
    V addVertex();
    E addEdge(V source, V target);
}