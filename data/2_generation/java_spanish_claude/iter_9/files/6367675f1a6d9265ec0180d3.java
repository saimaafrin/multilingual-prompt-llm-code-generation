import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;
import java.util.HashMap;
import java.util.Map;

public class GraphUtils {

    /**
     * Calcula un automorfismo de identidad (es decir, un mapeo propio de un grafo en el que cada vértice también se mapea a sí mismo).
     * @param grafo el grafo de entrada
     * @param <V> el tipo de vértice del grafo
     * @param <E> el tipo de arista del grafo
     * @return un mapeo de grafo a grafo
     */
    public static <V,E> IsomorphicGraphMapping<V,E> identidad(Graph<V,E> grafo) {
        // Crear mapeos de vértices y aristas
        Map<V,V> vertexMap = new HashMap<>();
        Map<E,E> edgeMap = new HashMap<>();
        
        // Mapear cada vértice a sí mismo
        for(V vertex : grafo.vertexSet()) {
            vertexMap.put(vertex, vertex);
        }
        
        // Mapear cada arista a sí misma
        for(E edge : grafo.edgeSet()) {
            edgeMap.put(edge, edge);
        }
        
        // Crear y retornar el mapeo isomórfico
        return new IsomorphicGraphMapping<>(
            grafo,    // grafo origen
            grafo,    // grafo destino
            vertexMap,// mapeo de vértices
            edgeMap   // mapeo de aristas
        );
    }
}