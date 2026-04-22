import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

import java.util.HashMap;
import java.util.Map;

public class GraphIdentity {

    /**
     * एक पहचान स्वचालन (यानी एक ग्राफ का आत्म-मैपिंग जिसमें प्रत्येक शीर्षक स्वयं को भी मैप करता है) की गणना करता है।
     * @param graph इनपुट ग्राफ
     * @param <V> ग्राफ शीर्षक प्रकार
     * @param <E> ग्राफ किनारा प्रकार
     * @return ग्राफ से ग्राफ तक का एक मैपिंग
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        Map<V, V> vertexMapping = new HashMap<>();
        Map<E, E> edgeMapping = new HashMap<>();

        // Map each vertex to itself
        for (V vertex : graph.vertexSet()) {
            vertexMapping.put(vertex, vertex);
        }

        // Map each edge to itself
        for (E edge : graph.edgeSet()) {
            edgeMapping.put(edge, edge);
        }

        return new IsomorphicGraphMapping<>(vertexMapping, edgeMapping, graph, graph);
    }
}