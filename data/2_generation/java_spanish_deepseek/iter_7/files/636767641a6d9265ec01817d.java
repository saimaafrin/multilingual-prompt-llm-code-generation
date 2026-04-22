import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     * 
     * @param target El grafo en el que se construirá el grafo bipartito completo.
     * @param resultMap Un mapa para almacenar los vértices generados.
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Supongamos que los vértices están divididos en dos conjuntos: U y V
        Set<V> setU = new HashSet<>();
        Set<V> setV = new HashSet<>();

        // Generar vértices para el conjunto U
        for (int i = 0; i < 5; i++) {
            V vertexU = target.addVertex();
            setU.add(vertexU);
            resultMap.put("U" + i, vertexU);
        }

        // Generar vértices para el conjunto V
        for (int i = 0; i < 5; i++) {
            V vertexV = target.addVertex();
            setV.add(vertexV);
            resultMap.put("V" + i, vertexV);
        }

        // Conectar cada vértice de U con cada vértice de V
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