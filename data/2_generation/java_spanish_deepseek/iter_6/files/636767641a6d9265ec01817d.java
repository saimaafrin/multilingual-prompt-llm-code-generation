import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BipartiteGraphGenerator<V, E> {

    /**
     * Construir un grafo bipartito completo
     * 
     * @param target El grafo en el que se construirá el grafo bipartito completo.
     * @param resultMap Un mapa para almacenar los vértices generados, donde la clave es un identificador único.
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // Supongamos que tenemos dos conjuntos de vértices: U y V
        List<V> setU = new ArrayList<>();
        List<V> setV = new ArrayList<>();

        // Crear vértices para el conjunto U
        for (int i = 0; i < 5; i++) { // Ejemplo: 5 vértices en U
            V vertex = target.addVertex();
            setU.add(vertex);
            resultMap.put("U" + i, vertex);
        }

        // Crear vértices para el conjunto V
        for (int i = 0; i < 5; i++) { // Ejemplo: 5 vértices en V
            V vertex = target.addVertex();
            setV.add(vertex);
            resultMap.put("V" + i, vertex);
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