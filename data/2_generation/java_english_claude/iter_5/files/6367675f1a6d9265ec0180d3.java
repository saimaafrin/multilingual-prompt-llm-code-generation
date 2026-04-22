import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.graph.AsGraphUnion;
import org.jgrapht.alg.isomorphism.IsomorphicGraphMapping;

public class GraphUtils {

    /**
     * Computes an identity automorphism (i.e. a self-mapping of a graph in which each vertex also maps to itself).
     * @param graph the input graph
     * @param <V> the graph vertex type
     * @param <E> the graph edge type
     * @return a mapping from graph to graph
     */
    public static <V,E> IsomorphicGraphMapping<V,E> identity(Graph<V,E> graph) {
        return new IsomorphicGraphMapping<V,E>(
            graph, // graph1 
            graph, // graph2 (same as graph1 for identity mapping)
            v -> v, // vertex correspondence function (identity)
            e -> e  // edge correspondence function (identity)
        );
    }
}