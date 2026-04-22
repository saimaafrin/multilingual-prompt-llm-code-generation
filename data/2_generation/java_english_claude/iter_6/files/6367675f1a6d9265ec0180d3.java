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
        return new IsomorphicGraphMapping<V,E>() {
            @Override
            public Graph<V, E> getGraph1() {
                return graph;
            }

            @Override
            public Graph<V, E> getGraph2() {
                return graph;
            }

            @Override
            public V getVertexCorrespondence(V vertex, boolean forward) {
                return vertex;
            }

            @Override
            public E getEdgeCorrespondence(E edge, boolean forward) {
                return edge;
            }

            @Override
            public boolean isEdgeCorrespondence(E e1, E e2) {
                return e1.equals(e2);
            }
        };
    }
}