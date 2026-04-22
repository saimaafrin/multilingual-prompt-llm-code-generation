import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

public class GraphIdentity {

    /**
     * एक पहचान स्वचालन (यानी एक ग्राफ का आत्म-मैपिंग जिसमें प्रत्येक शीर्षक स्वयं को भी मैप करता है) की गणना करता है।
     * @param graph इनपुट ग्राफ
     * @param <V> ग्राफ शीर्षक प्रकार
     * @param <E> ग्राफ किनारा प्रकार
     * @return ग्राफ से ग्राफ तक का एक मैपिंग
     */
    public static <V, E> IsomorphicGraphMapping<V, E> identity(Graph<V, E> graph) {
        // Create a mapping where each vertex maps to itself
        IsomorphicGraphMapping<V, E> mapping = new IsomorphicGraphMapping<>(graph, graph);
        for (V vertex : graph.vertexSet()) {
            mapping.addVertexMapping(vertex, vertex);
        }
        return mapping;
    }
}