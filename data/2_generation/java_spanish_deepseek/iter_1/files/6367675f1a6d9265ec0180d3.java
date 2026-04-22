import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

public class AutomorfismoIdentidad {

    /**
     * Calcula un automorfismo de identidad (es decir, un mapeo propio de un grafo en el que cada vértice también se mapea a sí mismo).
     * @param graph el grafo de entrada
     * @param <V> el tipo de vértice del grafo
     * @param <E> el tipo de arista del grafo
     * @return un mapeo de grafo a grafo
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identidad(Graph<V, E> graph) {
        // Crear un mapeo de identidad donde cada vértice se mapea a sí mismo
        IsomorphicGraphMapping<V, E> identityMapping = new IsomorphicGraphMapping<>(graph, graph);
        for (V vertex : graph.vertexSet()) {
            identityMapping.addVertexMapping(vertex, vertex);
        }
        return identityMapping;
    }
}